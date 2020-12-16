package sushishop

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure.ChainBuilder

object SushiMethods {

  val sushiBaseCsvFeeder = csv("sushiBase.csv").circular
  val clientsCsvFeeder = csv("clients.csv").circular

  val mainPage: ChainBuilder = exec(http("mainPage")
    .get("/")
    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
    .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:83.0) Gecko/20100101 Firefox/83.0")
  )

  val getOrders: ChainBuilder = exec(http("getOrders")
    .get("/api/orders")
    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
    .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:83.0) Gecko/20100101 Firefox/83.0")
  )

  val makeOrder: ChainBuilder = feed(sushiBaseCsvFeeder).feed(clientsCsvFeeder)
    .exec(http("makeOrder")
    .post("/api/orders")
    .body(ElFileBody("orderTemplate.json")).asJson
    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
    .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:83.0) Gecko/20100101 Firefox/83.0")
    .check(status.is(200))
  )

  /*val FirstChain: ChainBuilder =
    group("FirstChain"){
      exec(mainPage)
    }*/

}
