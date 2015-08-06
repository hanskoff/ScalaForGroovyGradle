package pl.jan

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.CompositeByteArrayBody
import scala.concurrent.duration._
/*
* Gatling simulation scripts are written in Scala, but don’t panic!
* You can use all the basic functions of Gatling without knowing much about Scala.
*
* Start bootzooka first!
* */

class Sample08Gatling extends Simulation {

  var counter:Long = System.currentTimeMillis

  val httpProtocol = http.baseURL(s"http://localhost:8080")

  val home = http("bootzooka").get("/").check(status.is(200))

  val register = http("registration").post("/api/users/register")
    .body(buildBodyJson).asJSON
    .check(status.is(201), regex("success").find(0).exists)

  val scn = scenario("load test")
    .exec(home)
    .exec { session => counter = counter + 1; session.set("counter", counter)}
    .pause(2 seconds)
    .exec(register)

  setUp( //http://gatling.io/docs/2.0.0-RC2/general/simulation_setup.html
    scn.inject(
      atOnceUsers(50)
    )
  ).assertions(global.failedRequests.count.is(0), global.responseTime.max.lessThan(1200))
    .protocols(httpProtocol)

  private def buildBodyJson: CompositeByteArrayBody = {
    StringBody("""{"login":"bo${counter}","email":"bo${counter}@johny.com","password":"johny"}""")
  }
}


//source: https://github.com/kui/gatling-gradle-example
//good read: http://gatling.io/docs/2.1.7/advanced_tutorial.html#advanced-tutorial