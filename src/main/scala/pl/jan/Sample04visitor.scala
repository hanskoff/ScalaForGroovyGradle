package pl.jan

/**

Visitor lets you define a new operation without changing the classes of the elements on which it operates.

  */
abstract class Animal {def walk: String}

case class Dog() extends Animal {override def walk = "on 4"}

case class Man() extends Animal {override def walk = "on 2"}

object Sample04visitor {

  /**
   * Visitor Pattern provides a solution to never-ending new
   * functionality that would otherwise be implemented with new
   * method in the hierarchy tree.
   */
  def talk(animal: Animal) = animal match {
    case Dog() => "wav wav"
    case Man() => "hi"
  }

  /**
   * New functionality implemented in separate methods that
   * uses pattern matching to implement tailored functionality.
   */
  def swim(animal: Animal) = animal match {
    case Dog() => "on 4"
    case Man() => "on 4"
  }
}
