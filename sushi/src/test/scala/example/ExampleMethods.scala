package example

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure.ChainBuilder

object ExampleMethods {

  val countryCsvFeeder = csv("countries.csv").circular

  val mainPage: ChainBuilder = exec(http("mainPage")
    .get("/wiki/Main_Page")
    .header("accept", "text/html")
    .header("user-agent", "Mozilla/5.0")
  )

  val searchPanel: ChainBuilder = exec(http("searchPanel")
    .get("/w/index.php")
    .queryParam("search","")
    .queryParam("title","Special:Search")
    .queryParam("go","Go")
    .header("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
    .header("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36"))

  val pushSearchButton: ChainBuilder = feed(countryCsvFeeder)
    .exec(http("pushSearchButton")
      .get("/w/index.php")
      .queryParam("sort","relevance")
      .queryParam("search","${country}")
      .queryParam("title","Special:Search")
      .queryParam("profile","advanced")
      .queryParam("fulltext","1")
      .queryParam("wprov","acrw1_0")
      .header("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
      .header("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36")
    )

  val privacyPolicy: ChainBuilder = exec(http("Privacy_policy")
    .get("https://foundation.wikimedia.org/wiki/Privacy_policy")
    .header("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
    .header("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36")
  )

  //Scenario 1
  val FirstChain: ChainBuilder =
    group("FirstChain"){
      exec(mainPage)
        .exec(searchPanel)
        .exec(pushSearchButton)
    }

  // Scenario 2

  val SecondChain: ChainBuilder =
    group("SecondChain"){
      exec(mainPage)
        .exec(privacyPolicy)
    }
}
