package example

import example.ExampleMethods._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure._

import scala.concurrent.duration.DurationInt

trait ExampleInjects extends  Simulation {

  def loader(scenario: ScenarioBuilder, scenario2: ScenarioBuilder) = {

    val httpProtocol = http.baseUrl("https://en.wikipedia.org")

    setUp(scenario.inject(constantUsersPerSec(10) during (2 minutes)).throttle(reachRps(10) in (1 minutes),holdFor(1 minutes)).protocols(httpProtocol),
      scenario2.inject(constantUsersPerSec(10) during (2 minutes)).throttle(reachRps(20) in (1 minutes),holdFor(1 minutes)).protocols(httpProtocol))
      .maxDuration(3 minutes)

  }
}
