package pl.jan

import org.scalatest.{FunSuite, GivenWhenThen}
import pl.jan.Sample01first._

class Sample01Test extends FunSuite with GivenWhenThen {

  test("should return evens") {
    Given("given list")
    val listFromOneToTen = List.range(1, 10)

    Then("filter with function")
    assert(listFromOneToTen.filter(evens) == List(2, 4, 6, 8))
    assert(listFromOneToTen.filter(evensTypeInferenced) == List(2, 4, 6, 8))
    assert(listFromOneToTen.filter(evensWildcard) == List(2, 4, 6, 8))
  }

}
