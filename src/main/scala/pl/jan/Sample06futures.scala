package pl.jan

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

/**
 * Having a list of futures I want to return with any that completed ?
 * not to fail whole computation
 **/
object Sample06futures extends App {

  val listOfFutures = List(
    Future.successful(1),
    Future.failed(new Exception("Failure")),
    Future.successful(3))

  // List[Future] to Future[List]
  val futureOfList = Future.sequence(listOfFutures)

  futureOfList onComplete {
    case Success(x) => println("Success!!! " + x)
    case Failure(ex) => println("Failed !!! " + ex)
  }

  Await.result(futureOfList, 1000 millis)

}
