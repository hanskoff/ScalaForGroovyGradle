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

  def fuseWithoutSugar[A, B](optA: Option[A], optB: Option[B]):Option[(A, B)] = {
    optA.flatMap(a => optB.map(b => (a, b)))
  }

  def fuseMap[A, B](optA: Option[A], optB: Option[B]):Option[Option[(A, B)]] = {
    optA.map(a => optB.map(b => (a, b)))
  }

  //Or return one that success and if both success - throw an exception
  def xor[T](x: Option[T], y: Option[T]): Option[T] = (x, y) match {
    case (Some(_), None) => x
    case (None, Some(_)) => y
    case (None, None) => None
    case _ => throw new Exception()
  }
}

//source: https://gist.github.com/loicdescotte/4044169