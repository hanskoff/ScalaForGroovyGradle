package pl.jan

import org.scalatest.{FunSuite, GivenWhenThen}
import pl.jan.Sample04visitor._

class Sample04Test extends FunSuite with GivenWhenThen {

  test("should make visitor talk") {
    Given("two subjects")
    val dog = new Dog
    val man = new Man

    Then("apply logic for types")
    assert("wav wav" == talk(dog))
    assert("hi" == talk(man))
  }
}
