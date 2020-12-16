package sushishop

import com.github.phisgr.gatling.grpc.Predef.{grpc, managedChannelBuilder}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure._

import scala.concurrent.duration.DurationInt

trait GrpcInjects  extends Simulation {


  def loader(scenario: ScenarioBuilder): SetUp = {

    val grpcConf = grpc(managedChannelBuilder("185.177.93.224", 50051).usePlaintext())
    val rps = 10

    setUp(scenario.inject(constantUsersPerSec(rps) during (6 minutes)).throttle(reachRps(rps) in (1 minutes),holdFor(5 minutes)).protocols(grpcConf),
     )
      .maxDuration(10 minutes)

  }
}
