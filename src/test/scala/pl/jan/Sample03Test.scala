package pl.jan

import org.scalatest.FunSuite
import pl.jan.Sample03option._

class Sample03Test extends FunSuite {

  test("should handle option tuple") {
    val optA: Option[String] = Some("a value")
    val optB: Option[String] = Some("b value")
    //then
    assert(fuse(optA, optB) == Some("a value", "b value"))
  }
}
