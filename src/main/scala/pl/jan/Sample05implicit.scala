package pl.jan

/**
 * Scala will consider the following implicit conversion functions:
 * 1. Implicit functions in the companion object of the source or target type
 * 2. Implicit functions that are in scope as a single identifier
 **/

object Sample05implicit extends App {
  //Example 01
  def add(x: Int, y: Int): Int = x + y
  println(s"add: ${add(1, 2)}")

  def addCurrying(x: Int)(y: Int): Int = x + y
  assert(addCurrying(1)(2) == 3)

  def addImplicit(x: Int)(implicit y: Int): Int = x + y
  addImplicit(1)(1)

  // addImpl(1) //this line won't work unless you provide implicit val as below for this scope

  implicit val one: Int = 1
  assert(addImplicit(1) == 2)


  //  Example 02 -  implicits are often used in conversions, take a look into Int class

  def printlnDouble(input: Double): Unit = {
    println(input)
  }

  // works because of int2double in Int class
  printlnDouble(one)
}

//source:https://youtu.be/sVMES4RZF-8?t=833