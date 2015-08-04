package pl.jan

import org.scalatest.FunSuite
import pl.jan.Sample02hof._

class Sample02Test extends FunSuite {

  test("should reverse string") {
    val x = "hello"
    assert("olleh"== stringOps(x, reverse))
  }

  test("should upper string") {
    val x = "hello"
    assert("HELLO"== stringOps(x, upper))
  }
}
