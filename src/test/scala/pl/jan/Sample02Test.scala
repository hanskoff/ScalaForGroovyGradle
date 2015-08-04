package pl.jan

import org.scalatest.FunSuite
import pl.jan.Sample02hofAndStategy._

class Sample02Test extends FunSuite {

  test("should reverse string") {
    val x = "hello"
    //then
    assert("olleh"== stringOps(x, reverse))
  }

  test("should upper string") {
    val x = "hello"
    //then
    assert("HELLO"== stringOps(x, upper))
  }

  test("should compose two functions") {
    val x = "hello"
    //then
    assert("OLLEH" == stringOps(x, compose(upper, reverse)))
  }
}
