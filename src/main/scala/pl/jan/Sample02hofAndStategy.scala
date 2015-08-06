package pl.jan

/**
 * higher-order functions = defining a method that accepts simple function parameter
 **/

object Sample02hofAndStategy {
  //
  def applyFun[A](payload: A, f: A => A):A = {
    f(payload)
  }

  //OOP strategy pattern
  val reverse = (s: String) => s.reverse

  val upper = (s: String) => s.toUpperCase

  // composing two strategies
  def compose[A, B, C](g: B => C, f: A => B): A => C = x => g(f(x))

}

//source: http://slides.com/kyeljohndavid/scala-in-a-nutshell#/14