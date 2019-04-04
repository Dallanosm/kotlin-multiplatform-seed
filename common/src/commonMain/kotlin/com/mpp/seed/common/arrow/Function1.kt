package com.mpp.seed.common.arrow


fun <I, O> ((I) -> O).k(): Function1<I, O> = Function1(this)

operator fun <I, O> Function1Of<I, O>.invoke(i: I): O = this.fix().f(i)

class ForFunction1 private constructor() {
    companion object
}
typealias Function1Of<I, O> = Kind2<ForFunction1, I, O>
typealias Function1PartialOf<I> = Kind<ForFunction1, I>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <I, O> Function1Of<I, O>.fix(): Function1<I, O> =
        this as Function1<I, O>

class Function1<I, out O>(val f: (I) -> O) : Function1Of<I, O> {

    fun <B> map(f: (O) -> B): Function1<I, B> = f.compose { a: I -> this.f(a) }.k()

    fun <B> contramap(f: (B) -> I): Function1<B, O> = (this.f compose f).k()

    fun <B> flatMap(f: (O) -> Function1Of<I, B>): Function1<I, B> = { p: I -> f(this.f(p))(p) }.k()

    fun <B> ap(ff: Function1Of<I, (O) -> B>): Function1<I, B> = ff.fix().flatMap { f -> map(f) }.fix()

    fun local(f: (I) -> I): Function1<I, O> = f.andThen { this(it) }.k()

    fun <B> compose(g: Function1<B, I>): Function1<B, O> = f.compose(g.f).k()

    companion object {

        fun <I> ask(): Function1<I, I> = { a: I -> a }.k()

        fun <I, A> just(a: A): Function1<I, A> = { _: I -> a }.k()

        private tailrec fun <I, A, B> step(a: A, t: I, fn: (A) -> Function1Of<I, Either<A, B>>): B {
            val af = fn(a)(t)
            return when (af) {
                is Either.Right -> af.b
                is Either.Left -> step(af.a, t, fn)
            }
        }

        fun <I, A, B> tailRecM(a: A, f: (A) -> Function1Of<I, Either<A, B>>): Function1<I, B> = { t: I -> step(a, t, f) }.k()

        fun <I> id(): Function1<I, I> = Function1(::identity)
    }
}
