package pl.jan

import org.scalatest.FunSuite
import pl.jan.Sample04visitor._

class Sample04Test extends FunSuite {

  test("should make visitor talk") {
    //given
    val dog = new Dog
    val man = new Man
    //when
    swim(dog)
    //then
    assert("wav wav" == talk(dog))
    assert("hi" == talk(man))
  }
}
