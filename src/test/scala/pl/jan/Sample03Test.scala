package pl.jan

import org.scalatest.{FunSuite, GivenWhenThen}
import pl.jan.Sample03option._

class Sample03Test extends FunSuite with GivenWhenThen {

  test("should handle option tuple") {

    Given("two option values")
    val optA: Option[Int] = Some(1)
    val optB: Option[String] = Some("b value")

    Then("got final option with tuple")
    assert(fuse(optA, optB) == Some(1, "b value"))
  }

  test("should return None when one is None") {

    Given("two options, one is None")
    val optA: Option[Int] = Some(1)
    val optB: Option[String] = None

    Then("got final None")
    assert(fuse(optA, optB).isEmpty)
  }
}
