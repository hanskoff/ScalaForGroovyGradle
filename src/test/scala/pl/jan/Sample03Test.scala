package pl.jan

import org.scalatest.FunSuite
import pl.jan.Sample02hof._
import pl.jan.Sample03strategy._

class Sample03Test extends FunSuite {

  test("should compose two functions") {
    val x = "hello"
    assert("OLLEH"== stringOps(x, compose(upper,reverse)))
  }
}
