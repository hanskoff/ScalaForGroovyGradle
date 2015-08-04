package pl.jan

/**
 * combining two options with for-comprehension
 */

object Sample03option {

  /** Excercise: The resulting Option object should contain a tuple of values from Option objects
    * optA and optB, given that both optA and optB are non-empty.
    */

  def fuse[A, B](optA: Option[A], optB: Option[B]): Option[(A, B)] = {
    for {
      a <- optA
      b <- optB
    } yield (a, b)
  }

  def fuseWithoutSugar[A, B](optA: Option[A], optB: Option[B]) = {
    optA.flatMap(a => optB.map(b => (a, b)))
  }
}

//source: https://gist.github.com/loicdescotte/4044169