package sushishop

import io.gatling.core.Predef.{Simulation, scenario}
import io.gatling.core.structure.ScenarioBuilder
import sushishop.SushiMethods._

class ReliabilitySimulation extends Simulation with ReliabilityInjects {

  def scenarioOne: ScenarioBuilder = scenario("scenarioOne").exec(mainPage)
  def scenarioTwo: ScenarioBuilder = scenario("scenarioTwo").exec(getOrders)
  def scenarioThree: ScenarioBuilder = scenario("scenarioThree").exec(makeOrder)

  loader(scenarioOne, scenarioTwo, scenarioThree)
}
