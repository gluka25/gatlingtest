package sushishop

import io.gatling.core.Predef.{Simulation, scenario}
import io.gatling.core.structure.ScenarioBuilder
import sushishop.GrpcMethods.grpcList

class GrpcSimulation extends Simulation with GrpcInjects {

  def scenarioOne: ScenarioBuilder = scenario("scenarioOne").exec(grpcList)

  loader(scenarioOne)
}
