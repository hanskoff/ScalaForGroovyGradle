package pl.jan

import org.scalatest.FunSuite
import pl.jan.Sample02hofAndStategy._

class Sample02Test extends FunSuite {

  val hello = "hello"

  test("should reverse string") {
    assert("olleh" == applyFun(hello, reverse))
  }

  test("should upper string") {
    assert("HELLO" == applyFun(hello, upper))
  }

  test("should compose two functions") {
    assert("OLLEH" == applyFun(hello, compose(upper, reverse)))
  }
}
