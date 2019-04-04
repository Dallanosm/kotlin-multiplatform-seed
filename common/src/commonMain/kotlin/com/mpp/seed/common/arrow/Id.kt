package com.mpp.seed.common.arrow

fun <A> IdOf<A>.value(): A = this.fix().extract()

class ForId private constructor() { companion object }
typealias IdOf<A> = Kind<ForId, A>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A> IdOf<A>.fix(): Id<A> =
        this as Id<A>

data class Id<out A>(private val value: A) : IdOf<A> {

  inline fun <B> map(f: (A) -> B): Id<B> = Id(f(extract()))

  inline fun <B> flatMap(f: (A) -> IdOf<B>): Id<B> = f(extract()).fix()

  fun <B> foldLeft(initial: B, operation: (B, A) -> B): B = operation(initial, value)

  fun <B> foldRight(initial: Eval<B>, operation: (A, Eval<B>) -> Eval<B>): Eval<B> = operation(value, initial)

  fun <B> coflatMap(f: (IdOf<A>) -> B): Id<B> = this.fix().map { f(this) }

  fun extract(): A = value

  fun <B> ap(ff: IdOf<(A) -> B>): Id<B> = ff.fix().flatMap { f -> map(f) }.fix()

  companion object {

    tailrec fun <A, B> tailRecM(a: A, f: (A) -> IdOf<Either<A, B>>): Id<B> {
      val x: Either<A, B> = f(a).value()
      return when (x) {
        is Either.Left -> tailRecM(x.a, f)
        is Either.Right -> Id(x.b)
      }
    }

    fun <A> just(a: A): Id<A> = Id(a)
  }

  override fun equals(other: Any?): Boolean =
    when (other) {
      is Id<*> -> other.value == value
      else -> other == value
    }

  override fun hashCode(): Int = value.hashCode()

}
