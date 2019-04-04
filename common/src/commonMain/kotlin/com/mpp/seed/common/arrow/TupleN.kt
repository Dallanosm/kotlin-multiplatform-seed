package com.mpp.seed.common.arrow

class ForTuple2 private constructor() {
    companion object
}
typealias Tuple2Of<A, B> = Kind2<ForTuple2, A, B>
typealias Tuple2PartialOf<A> = Kind<ForTuple2, A>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B> Tuple2Of<A, B>.fix(): Tuple2<A, B> =
        this as Tuple2<A, B>

data class Tuple2<out A, out B>(val a: A, val b: B) : Tuple2Of<A, B> {
    fun <C> map(f: (B) -> C) =
            a toT f(b)

    fun <C, D> bimap(fl: (A) -> C, fr: (B) -> D) =
            fl(a) toT fr(b)

    fun <C> ap(f: Tuple2Of<*, (B) -> C>) =
            map(f.fix().b)

    fun <C> flatMap(f: (B) -> Tuple2Of<@UnsafeVariance A, C>) =
            f(b).fix()

    fun <C> coflatMap(f: (Tuple2Of<A, B>) -> C) =
            a toT f(this)

    fun extract() =
            b

    fun <C> foldL(b: C, f: (C, B) -> C) =
            f(b, this.b)

    fun <C> foldR(lb: Eval<C>, f: (B, Eval<C>) -> Eval<C>) =
            f(b, lb)

    fun reverse(): Tuple2<B, A> = Tuple2(b, a)

    companion object
}

class ForTuple3 private constructor() {
    companion object
}
typealias Tuple3Of<A, B, C> = Kind3<ForTuple3, A, B, C>
typealias Tuple3PartialOf<A, B> = Kind2<ForTuple3, A, B>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C> Tuple3Of<A, B, C>.fix(): Tuple3<A, B, C> =
        this as Tuple3<A, B, C>

data class Tuple3<out A, out B, out C>(val a: A, val b: B, val c: C) : Tuple3Of<A, B, C> {
    fun reverse(): Tuple3<C, B, A> = Tuple3(c, b, a)

    companion object
}

class ForTuple4 private constructor() {
    companion object
}
typealias Tuple4Of<A, B, C, D> = Kind4<ForTuple4, A, B, C, D>
typealias Tuple4PartialOf<A, B, C> = Kind3<ForTuple4, A, B, C>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D> Tuple4Of<A, B, C, D>.fix(): Tuple4<A, B, C, D> =
        this as Tuple4<A, B, C, D>

data class Tuple4<out A, out B, out C, out D>(val a: A, val b: B, val c: C, val d: D) : Tuple4Of<A, B, C, D> {
    companion object
}

class ForTuple5 private constructor() {
    companion object
}
typealias Tuple5Of<A, B, C, D, E> = Kind5<ForTuple5, A, B, C, D, E>
typealias Tuple5PartialOf<A, B, C, D> = Kind4<ForTuple5, A, B, C, D>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E> Tuple5Of<A, B, C, D, E>.fix(): Tuple5<A, B, C, D, E> =
        this as Tuple5<A, B, C, D, E>

data class Tuple5<out A, out B, out C, out D, out E>(val a: A, val b: B, val c: C, val d: D, val e: E) : Tuple5Of<A, B, C, D, E> {
    companion object
}

class ForTuple6 private constructor() {
    companion object
}
typealias Tuple6Of<A, B, C, D, E, F> = Kind6<ForTuple6, A, B, C, D, E, F>
typealias Tuple6PartialOf<A, B, C, D, E> = Kind5<ForTuple6, A, B, C, D, E>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F> Tuple6Of<A, B, C, D, E, F>.fix(): Tuple6<A, B, C, D, E, F> =
        this as Tuple6<A, B, C, D, E, F>

data class Tuple6<out A, out B, out C, out D, out E, out F>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F) : Tuple6Of<A, B, C, D, E, F> {
    companion object
}

class ForTuple7 private constructor() {
    companion object
}
typealias Tuple7Of<A, B, C, D, E, F, G> = Kind7<ForTuple7, A, B, C, D, E, F, G>
typealias Tuple7PartialOf<A, B, C, D, E, F> = Kind6<ForTuple7, A, B, C, D, E, F>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G> Tuple7Of<A, B, C, D, E, F, G>.fix(): Tuple7<A, B, C, D, E, F, G> =
        this as Tuple7<A, B, C, D, E, F, G>


data class Tuple7<out A, out B, out C, out D, out E, out F, out G>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G) : Tuple7Of<A, B, C, D, E, F, G> {
    companion object
}

class ForTuple8 private constructor() {
    companion object
}
typealias Tuple8Of<A, B, C, D, E, F, G, H> = Kind8<ForTuple8, A, B, C, D, E, F, G, H>
typealias Tuple8PartialOf<A, B, C, D, E, F, G> = Kind7<ForTuple8, A, B, C, D, E, F, G>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H> Tuple8Of<A, B, C, D, E, F, G, H>.fix(): Tuple8<A, B, C, D, E, F, G, H> =
        this as Tuple8<A, B, C, D, E, F, G, H>

data class Tuple8<out A, out B, out C, out D, out E, out F, out G, out H>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H) : Tuple8Of<A, B, C, D, E, F, G, H> {
    companion object
}

class ForTuple9 private constructor() {
    companion object
}
typealias Tuple9Of<A, B, C, D, E, F, G, H, I> = Kind9<ForTuple9, A, B, C, D, E, F, G, H, I>
typealias Tuple9PartialOf<A, B, C, D, E, F, G, H> = Kind8<ForTuple9, A, B, C, D, E, F, G, H>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I> Tuple9Of<A, B, C, D, E, F, G, H, I>.fix(): Tuple9<A, B, C, D, E, F, G, H, I> =
        this as Tuple9<A, B, C, D, E, F, G, H, I>

data class Tuple9<out A, out B, out C, out D, out E, out F, out G, out H, out I>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I) : Tuple9Of<A, B, C, D, E, F, G, H, I> {
    companion object
}

class ForTuple10 private constructor() {
    companion object
}
typealias Tuple10Of<A, B, C, D, E, F, G, H, I, J> = Kind10<ForTuple10, A, B, C, D, E, F, G, H, I, J>
typealias Tuple10PartialOf<A, B, C, D, E, F, G, H, I> = Kind9<ForTuple10, A, B, C, D, E, F, G, H, I>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J> Tuple10Of<A, B, C, D, E, F, G, H, I, J>.fix(): Tuple10<A, B, C, D, E, F, G, H, I, J> =
        this as Tuple10<A, B, C, D, E, F, G, H, I, J>

data class Tuple10<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J) : Tuple10Of<A, B, C, D, E, F, G, H, I, J> {
    companion object
}

class ForTuple11 private constructor() {
    companion object
}
typealias Tuple11Of<A, B, C, D, E, F, G, H, I, J, K> = Kind11<ForTuple11, A, B, C, D, E, F, G, H, I, J, K>
typealias Tuple11PartialOf<A, B, C, D, E, F, G, H, I, J> = Kind10<ForTuple11, A, B, C, D, E, F, G, H, I, J>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J, K> Tuple11Of<A, B, C, D, E, F, G, H, I, J, K>.fix(): Tuple11<A, B, C, D, E, F, G, H, I, J, K> =
        this as Tuple11<A, B, C, D, E, F, G, H, I, J, K>


data class Tuple11<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J, val k: K) : Tuple11Of<A, B, C, D, E, F, G, H, I, J, K> {
    companion object
}

class ForTuple12 private constructor() {
    companion object
}
typealias Tuple12Of<A, B, C, D, E, F, G, H, I, J, K, L> = Kind12<ForTuple12, A, B, C, D, E, F, G, H, I, J, K, L>
typealias Tuple12PartialOf<A, B, C, D, E, F, G, H, I, J, K> = Kind11<ForTuple12, A, B, C, D, E, F, G, H, I, J, K>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J, K, L> Tuple12Of<A, B, C, D, E, F, G, H, I, J, K, L>.fix(): Tuple12<A, B, C, D, E, F, G, H, I, J, K, L> =
        this as Tuple12<A, B, C, D, E, F, G, H, I, J, K, L>

data class Tuple12<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J, val k: K, val l: L) : Tuple12Of<A, B, C, D, E, F, G, H, I, J, K, L> {
    companion object
}

class ForTuple13 private constructor() {
    companion object
}
typealias Tuple13Of<A, B, C, D, E, F, G, H, I, J, K, L, M> = Kind13<ForTuple13, A, B, C, D, E, F, G, H, I, J, K, L, M>
typealias Tuple13PartialOf<A, B, C, D, E, F, G, H, I, J, K, L> = Kind12<ForTuple13, A, B, C, D, E, F, G, H, I, J, K, L>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J, K, L, M> Tuple13Of<A, B, C, D, E, F, G, H, I, J, K, L, M>.fix(): Tuple13<A, B, C, D, E, F, G, H, I, J, K, L, M> =
        this as Tuple13<A, B, C, D, E, F, G, H, I, J, K, L, M>

data class Tuple13<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J, val k: K, val l: L, val m: M) : Tuple13Of<A, B, C, D, E, F, G, H, I, J, K, L, M> {
    companion object
}

class ForTuple14 private constructor() {
    companion object
}
typealias Tuple14Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N> = Kind14<ForTuple14, A, B, C, D, E, F, G, H, I, J, K, L, M, N>
typealias Tuple14PartialOf<A, B, C, D, E, F, G, H, I, J, K, L, M> = Kind13<ForTuple14, A, B, C, D, E, F, G, H, I, J, K, L, M>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N> Tuple14Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N>.fix(): Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N> =
        this as Tuple14<A, B, C, D, E, F, G, H, I, J, K, L, M, N>

data class Tuple14<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J, val k: K, val l: L, val m: M, val n: N) : Tuple14Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N> {
    companion object
}

class ForTuple15 private constructor() {
    companion object
}
typealias Tuple15Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> = Kind15<ForTuple15, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O>
typealias Tuple15PartialOf<A, B, C, D, E, F, G, H, I, J, K, L, M, N> = Kind14<ForTuple15, A, B, C, D, E, F, G, H, I, J, K, L, M, N>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> Tuple15Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O>.fix(): Tuple15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> =
        this as Tuple15<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O>

data class Tuple15<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J, val k: K, val l: L, val m: M, val n: N, val o: O) : Tuple15Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> {
    companion object
}

class ForTuple16 private constructor() {
    companion object
}
typealias Tuple16Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> = Kind16<ForTuple16, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P>
typealias Tuple16PartialOf<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O> = Kind15<ForTuple16, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> Tuple16Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P>.fix(): Tuple16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> =
        this as Tuple16<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P>


data class Tuple16<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J, val k: K, val l: L, val m: M, val n: N, val o: O, val p: P) : Tuple16Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> {
    companion object
}

class ForTuple17 private constructor() {
    companion object
}
typealias Tuple17Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> = Kind17<ForTuple17, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q>
typealias Tuple17PartialOf<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P> = Kind16<ForTuple17, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> Tuple17Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q>.fix(): Tuple17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> =
        this as Tuple17<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q>

data class Tuple17<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J, val k: K, val l: L, val m: M, val n: N, val o: O, val p: P, val q: Q) : Tuple17Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> {
    companion object
}

class ForTuple18 private constructor() {
    companion object
}
typealias Tuple18Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> = Kind18<ForTuple18, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R>
typealias Tuple18PartialOf<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q> = Kind17<ForTuple18, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> Tuple18Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R>.fix(): Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> =
        this as Tuple18<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R>


data class Tuple18<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J, val k: K, val l: L, val m: M, val n: N, val o: O, val p: P, val q: Q, val r: R) : Tuple18Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> {
    companion object
}

class ForTuple19 private constructor() {
    companion object
}
typealias Tuple19Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> = Kind19<ForTuple19, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S>
typealias Tuple19PartialOf<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R> = Kind18<ForTuple19, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> Tuple19Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S>.fix(): Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> =
        this as Tuple19<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S>


data class Tuple19<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J, val k: K, val l: L, val m: M, val n: N, val o: O, val p: P, val q: Q, val r: R, val s: S) : Tuple19Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> {
    companion object
}

class ForTuple20 private constructor() {
    companion object
}
typealias Tuple20Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> = Kind20<ForTuple20, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T>
typealias Tuple20PartialOf<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S> = Kind19<ForTuple20, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> Tuple20Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T>.fix(): Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> =
        this as Tuple20<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T>

data class Tuple20<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J, val k: K, val l: L, val m: M, val n: N, val o: O, val p: P, val q: Q, val r: R, val s: S, val t: T) : Tuple20Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> {
    companion object
}

class ForTuple21 private constructor() {
    companion object
}
typealias Tuple21Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> = Kind21<ForTuple21, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U>
typealias Tuple21PartialOf<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T> = Kind20<ForTuple21, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> Tuple21Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U>.fix(): Tuple21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> =
        this as Tuple21<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U>


data class Tuple21<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J, val k: K, val l: L, val m: M, val n: N, val o: O, val p: P, val q: Q, val r: R, val s: S, val t: T, val u: U) : Tuple21Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> {
    companion object
}

class ForTuple22 private constructor() {
    companion object
}
typealias Tuple22Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> = Kind22<ForTuple22, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V>
typealias Tuple22PartialOf<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U> = Kind21<ForTuple22, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U>

@Suppress("UNCHECKED_CAST", "NOTHING_TO_INLINE")
inline fun <A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> Tuple22Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V>.fix(): Tuple22<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> =
        this as Tuple22<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V>


data class Tuple22<out A, out B, out C, out D, out E, out F, out G, out H, out I, out J, out K, out L, out M, out N, out O, out P, out Q, out R, out S, out T, out U, out V>(val a: A, val b: B, val c: C, val d: D, val e: E, val f: F, val g: G, val h: H, val i: I, val j: J, val k: K, val l: L, val m: M, val n: N, val o: O, val p: P, val q: Q, val r: R, val s: S, val t: T, val u: U, val v: V) : Tuple22Of<A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V> {
    companion object
}

private const val INT_MAX_POWER_OF_TWO: Int = Int.MAX_VALUE / 2 + 1

infix fun <A, B> A.toT(b: B): Tuple2<A, B> = Tuple2(this, b)

fun <K, V> Tuple2<K, V>.toPair(): Pair<K, V> = Pair(this.a, this.b)

fun <K, V> Pair<K, V>.toTuple2(): Tuple2<K, V> = Tuple2(this.first, this.second)

fun <K, V> mapOf(vararg tuples: Tuple2<K, V>): Map<K, V> =
        if (tuples.isNotEmpty()) tuples.toMap(LinkedHashMap(mapCapacity(tuples.size))) else emptyMap()

fun <K, V> Iterable<Tuple2<K, V>>.toMap(): Map<K, V> {
    if (this is Collection) {
        return when (size) {
            0 -> emptyMap()
            1 -> mapOf(if (this is List) this[0] else iterator().next())
            else -> toMap(LinkedHashMap(mapCapacity(size)))
        }
    }
    return toMap(LinkedHashMap()).optimizeReadOnlyMap()
}

fun <K, V> Array<out Tuple2<K, V>>.toMap(): Map<K, V> = when (size) {
    0 -> emptyMap()
    1 -> mapOf(this[0])
    else -> toMap(LinkedHashMap(mapCapacity(size)))
}

fun <K, V> Sequence<Tuple2<K, V>>.toMap(): Map<K, V> = toMap(LinkedHashMap()).optimizeReadOnlyMap()

fun <K, V> mapOf(pair: Tuple2<K, V>): Map<K, V> = mutableMapOf(Pair(pair.a, pair.b))

internal fun <K, V, M : MutableMap<in K, in V>> Iterable<Tuple2<K, V>>.toMap(destination: M): M =
        destination.apply { putAll(this@toMap) }

internal fun <K, V, M : MutableMap<in K, in V>> Array<out Tuple2<K, V>>.toMap(destination: M): M =
        destination.apply { putAll(this@toMap) }

internal fun <K, V, M : MutableMap<in K, in V>> Sequence<Tuple2<K, V>>.toMap(destination: M): M =
        destination.apply { putAll(this@toMap) }

internal fun <K, V> MutableMap<in K, in V>.putAll(tuples: Iterable<Tuple2<K, V>>) {
    for ((key, value) in tuples) {
        put(key, value)
    }
}

internal fun <K, V> MutableMap<in K, in V>.putAll(tuples: Array<out Tuple2<K, V>>) {
    for ((key, value) in tuples) {
        put(key, value)
    }
}

internal fun <K, V> MutableMap<in K, in V>.putAll(tuples: Sequence<Tuple2<K, V>>) {
    for ((key, value) in tuples) {
        put(key, value)
    }
}

operator fun <K, V> Map<out K, V>.plus(tuple: Tuple2<K, V>): Map<K, V> =
        if (this.isEmpty()) mapOf(tuple) else LinkedHashMap(this).apply { put(tuple.a, tuple.b) }

operator fun <K, V> Map<out K, V>.plus(tuples: Iterable<Tuple2<K, V>>): Map<K, V> =
        if (this.isEmpty()) tuples.toMap() else LinkedHashMap(this).apply { putAll(tuples) }

operator fun <K, V> Map<out K, V>.plus(tuples: Array<out Tuple2<K, V>>): Map<K, V> =
        if (this.isEmpty()) tuples.toMap() else LinkedHashMap(this).apply { putAll(tuples) }

operator fun <K, V> Map<out K, V>.plus(tuples: Sequence<Tuple2<K, V>>): Map<K, V> =
        LinkedHashMap(this).apply { putAll(tuples) }.optimizeReadOnlyMap()

fun <K, V> Map.Entry<K, V>.toTuple2(): Tuple2<K, V> = Tuple2(key, value)

internal fun mapCapacity(expectedSize: Int): Int =
        when {
            expectedSize < 3 -> expectedSize + 1
            expectedSize < INT_MAX_POWER_OF_TWO -> expectedSize + expectedSize / 3
            else -> Int.MAX_VALUE
        }

// do not expose for now @PublishedApi
internal fun <K, V> Map<K, V>.optimizeReadOnlyMap() =
        when (size) {
            0 -> emptyMap()
            1 -> this.toSingletonMap()
            else -> this
        }

// creates a singleton copy of map
internal fun <K, V> Map<out K, V>.toSingletonMap(): Map<K, V> =
        with(entries.iterator().next()) {
            mutableMapOf(Pair(key, value))
        }
