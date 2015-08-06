package pl.jan

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}

object Sample06solution extends App {

  val listOfFutures = List(
    Future.successful(1),
    Future.failed(new Exception("Failure")),
    Future.successful(3))

  def futureToFutureTry[T](f: Future[T]): Future[Try[T]] =
    f.map(Success(_)).recover { case x: Throwable => Failure(x) }

  val listOfFutureTrys = listOfFutures.map(futureToFutureTry(_))

  val futureListOfTrys = Future.sequence(listOfFutureTrys)

  futureListOfTrys onComplete {
    case Success(x) => println("Success!!! " + x)
    case Failure(ex) => println("Failed !!! " + ex)
  }

  Await.result(futureListOfTrys, 1000 millis)

  val futureListOfSuccesses = futureListOfTrys.map(_.filter(_.isSuccess))

  val futureListOfFailures = futureListOfTrys.map(_.filter(_.isFailure))
}

//source:http://stackoverflow.com/questions/20874186/scala-listfuture-to-futurelist-disregarding-failed-futures