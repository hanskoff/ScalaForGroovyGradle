package pl.jan

class Car {
  def turn(direction: String) = {
    println("turning " + direction)
  }
}

object Sample00dsl extends App{
  val javaCar = new Car();
  javaCar.turn("left");

  val car = new Car
  car turn "left"

}

//source: https://youtu.be/LH75sJAR0hc?t=1725