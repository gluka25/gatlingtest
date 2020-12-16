package sushishop

import io.gatling.core.Predef._
import io.gatling.core.controller.throttle.ThrottleStep
import io.gatling.http.Predef._
import io.gatling.core.structure._

import scala.collection.mutable
import scala.concurrent.duration.DurationInt

trait SushiInjects extends Simulation {

  def loader(scenario: ScenarioBuilder, scenario2: ScenarioBuilder, scenario3: ScenarioBuilder): SetUp = {

    val httpProtocol = http.baseUrl("http://185.177.93.224:3000")
    val rpsMain = 10
    val rpsGet = 5
    val rpsPost = 2

    setUp(scenario.inject(constantUsersPerSec(20) during (25 minutes)).throttle(getThrottles(rpsMain)).protocols(httpProtocol),
      scenario2.inject(constantUsersPerSec(10) during (25 minutes)).throttle(getThrottles(rpsGet)).protocols(httpProtocol),
      scenario3.inject(constantUsersPerSec(10) during (25 minutes)).throttle(getThrottles(rpsPost)).protocols(httpProtocol)
    )
      .maxDuration(30 minutes)

  }

  def getThrottles(rps: Int): mutable.MutableList[ThrottleStep] = {
    val throttles = mutable.MutableList(reachRps(rps) in (1 minutes), holdFor(5 minutes))
    for (i <- 0 to 4) {
      throttles += jumpToRps(rps + (rps * 20) * (i + 1) / 100)
      throttles += holdFor(3 minutes)
    }
    return throttles;
  }
}