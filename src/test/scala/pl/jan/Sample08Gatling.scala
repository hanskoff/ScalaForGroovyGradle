package pl.jan

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/*
* Gatling simulation scripts are written in Scala, but don’t panic!
* You can use all the basic functions of Gatling without knowing much about Scala.
*
* Start bootzooka first!
* */

class Sample08Gatling extends Simulation {

  val httpProtocol = http.baseURL(s"http://localhost:8080")

  val home = http("bootzooka").get("/").check(status.is(200))

  val register = http("regist")
    .post("/api/users/register")
    .body(StringBody(s"""{"login":"bob${inc()}","email":"bob${inc()}@johny.com","password":"johny"}""")).asJSON
    .check(status.is(201), regex("success").find(0).exists)

  val scn = scenario("load test")
    .exec(home)
    .pause(2)
    .exec(register)

  setUp(
    scn.inject(
      atOnceUsers(1)
    )
  ).assertions(global.failedRequests.count.is(0), global.responseTime.max.lessThan(1200))
    .protocols(httpProtocol)

  val r = scala.util.Random

  var counter = r.nextInt(1000000)

  def inc(): Int = {
    counter += 1
    counter
  }
}


//source: https://github.com/kui/gatling-gradle-example
//good read: http://gatling.io/docs/2.1.7/advanced_tutorial.html#advanced-tutorial