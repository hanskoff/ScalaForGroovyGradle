package pl.jan

/**
 * funtions are first class citizens = funtions as variables
 *
 **/
object Sample01first {

  val evens: Int => Boolean = (i: Int) => i % 2 == 0

}
