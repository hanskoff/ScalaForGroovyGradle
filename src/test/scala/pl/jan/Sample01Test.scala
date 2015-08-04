package pl.jan

import org.scalatest.FunSuite
import pl.jan.Sample01first._

class Sample01Test extends FunSuite {

   test("should return evens") {
     val x = List.range(1, 10)
     assert(x.filter(evens) == List(2, 4, 6, 8))
   }

 }
