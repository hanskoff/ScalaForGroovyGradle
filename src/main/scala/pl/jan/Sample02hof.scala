package pl.jan

object Sample02hof {
  //higher-order functions = defining a method that accepts simple function parameter
  def stringOps(s: String, f: String => String) = {
    if (s == null) "" else f(s)
  }

  //OOP strategy pattern
  val reverse = (s: String) => s.reverse

  val upper = (s: String) => s.toUpperCase



}
