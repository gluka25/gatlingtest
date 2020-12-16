package sushishop

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure._
import sushishop.SushiMethods._

class SushiSimulation extends Simulation with SushiInjects  {

  def scenarioOne: ScenarioBuilder = scenario("scenarioOne").exec(mainPage)
  def scenarioTwo: ScenarioBuilder = scenario("scenarioTwo").exec(getOrders)
  def scenarioThree: ScenarioBuilder = scenario("scenarioThree").exec(makeOrder)


  loader(scenarioOne, scenarioTwo, scenarioThree)
}
