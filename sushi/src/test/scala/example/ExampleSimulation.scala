package example

import example.ExampleMethods._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure._

class ExampleSimulation extends Simulation with ExampleInjects {

  def scenarioOne: ScenarioBuilder = scenario("scenarioOne").exec(FirstChain)
  def scenarioTwo: ScenarioBuilder = scenario("scenarioTwo").exec(SecondChain)

  loader(scenarioOne,scenarioTwo)
}
