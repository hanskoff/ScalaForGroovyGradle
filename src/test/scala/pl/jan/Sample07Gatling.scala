package pl.jan

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/*
* Gatling simulation scripts are written in Scala, but don’t panic!
* You can use all the basic functions of Gatling without knowing much about Scala.
* */

class Sample07Gatling extends Simulation {

  val httpProtocol = http.baseURL(s"http://computer-database.gatling.io")

  val scn = scenario("foo load test")
    .exec(http("Mark").get("/computers"))

  setUp(
    scn.inject(
      atOnceUsers(1)
    )
  ).protocols(httpProtocol)
}


//source: https://github.com/kui/gatling-gradle-example
//good read: http://gatling.io/docs/2.1.7/advanced_tutorial.html#advanced-tutorial