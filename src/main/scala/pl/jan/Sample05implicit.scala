package pl.jan

object Sample05implicit extends App {

  def add(x: Int, y: Int): Int = x + y
  println(s"add: ${add(1, 2)}")


  def addCur(x: Int)(y: Int): Int = x + y
  assert(addCur(1)(2) == 3)


  def addImpl(x: Int)(implicit y: Int): Int = x + y
  addImpl(1)(1) //works

  addImpl(1) //doesn't until you give it implicit value

  implicit val one: Int = 1
  assert(addImpl(1) == 2)

}

//source:https://youtu.be/sVMES4RZF-8?t=833