package pl.jan

class Car {
  def turn(direction: String): Unit = {
    println("turning " + direction)
  }
}

object Sample00dsl extends App {
  val javaCar = new Car();
  javaCar.turn("left");

  // omission of parentheses (only for no arguments)
  val car = new Car

  //infix notation (syntax for one argument only)
  car turn "left"

  //infix notation
  val names = List("Jan", "Wojtek")
  names map (_.toUpperCase) filter (_.length > 5)

}

//source: http://docs.scala-lang.org/style/method-invocation.html
//source: https://youtu.be/LH75sJAR0hc?t=1725