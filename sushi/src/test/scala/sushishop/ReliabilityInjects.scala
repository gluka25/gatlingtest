package sushishop

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure._

import scala.concurrent.duration.DurationInt

trait ReliabilityInjects extends Simulation {
  def loader(scenario: ScenarioBuilder, scenario2: ScenarioBuilder, scenario3: ScenarioBuilder): SetUp = {

    val httpProtocol = http.baseUrl("http://185.177.93.224:3000")
    val rpsMain = 10
    val rpsGet = 5
    val rpsPost = 2

    setUp(scenario.inject(constantUsersPerSec(rpsMain) during (70 minutes)).throttle(reachRps(rpsMain * 80 / 100) in (1 minutes),holdFor(1 hours)).protocols(httpProtocol),
      scenario2.inject(constantUsersPerSec(rpsGet) during (70 minutes)).throttle(reachRps(rpsGet * 80 / 100) in (1 minutes),holdFor(1 hours)).protocols(httpProtocol),
      scenario3.inject(constantUsersPerSec(rpsPost) during (70 minutes)).throttle(reachRps(rpsPost * 80 / 100) in (1 minutes),holdFor(1 hours)).protocols(httpProtocol)
    )
      .maxDuration(70 minutes)

  }
}
