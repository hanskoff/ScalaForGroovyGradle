package pl.jan

/**
 * funtions are first class citizens = funtions as variables
 *
 **/
object Sample01first {

  val evens: Int => Boolean = (i: Int) => i % 2 == 0

  val evensTypeInferenced = (i: Int) => i % 2 == 0

  val evensWildcard: Int => Boolean = _ % 2 ==0

}
