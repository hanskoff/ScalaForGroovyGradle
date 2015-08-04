package pl.jan

object Sample03strategy {
  // composing two strategies
  def compose[A, B, C](g: B => C, f: A => B): A => C = x => g(f(x))

  //  combining two options with for-comprehension
  def fuse[A, B](a: Option[A], b: Option[B]): Option[(A, B)] = {
    for {
      a1 <- a
      b1 <- b
    } yield (a1, b1)
  }
}
