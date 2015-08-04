package pl.jan

/**
 * combining two options with for-comprehension
 **/

object Sample03option {

  def fuse[A, B](a: Option[A], b: Option[B]): Option[(A, B)] = {
    for {
      a1 <- a
      b1 <- b
    } yield (a1, b1)
  }

  def rawFuse[A, B](a: Option[A], b: Option[B]) = {
    a.flatMap(a1 => b.map(b1 => (a1, b1)))
  }
}

//source: https://gist.github.com/loicdescotte/4044169