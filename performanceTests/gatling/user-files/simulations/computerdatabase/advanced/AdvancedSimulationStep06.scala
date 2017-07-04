/**
 * Copyright 2011-2017 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package computerdatabase.advanced

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import java.util.concurrent.ThreadLocalRandom

class AdvancedSimulationStep06 extends Simulation {

  // Let's split this big scenario into composable business processes, like one would do with PageObject pattern with Selenium

  // object are native Scala singletons
  object Search {

    val search = exec(http("Home") // let's give proper names, they are displayed in the reports, and used as keys
      .get("/"))
      .pause(1) // let's set the pauses to 1 sec for demo purpose
      .exec(http("Search")
        .get("/computers?f=macbook"))
      .pause(1)
      .exec(http("Select")
        .get("/computers/6"))
      .pause(1)
  }

  object Search03 {

    // We need dynamic data so that all users don't play the same and we end up with a behavior completely different from the live system (caching, JIT...)
    // ==> Feeders!

    val feeder = csv("search.csv").random // default is queue, so for this test, we use random to avoid feeder starvation

      val search03 = exec(http("Home")
       .get("/"))
       .pause(1)
       .feed(feeder) // every time a user passes here, a record is popped from the feeder and injected into the user's session
       .exec(http("Search")
         .get("/computers?f=${searchCriterion}") // use session data thanks to Gatling's EL
         .check(css("a:contains('${searchComputerName}')", "href").saveAs("computerURL"))) // use a CSS selector with an EL, save the result of the capture group
       .pause(1)
       .exec(http("Select")
         .get("${computerURL}") // use the link previously saved
         .check(status.is(200)))
       .pause(1)
  }

  object Search04 {

      val feeder = csv("search.csv").random

      val search04 = exec(http("Home")
        .get("/"))
        .pause(1)
        .feed(feeder)
        .exec(http("Search")
          .get("/computers?f=${searchCriterion}")
          .check(css("a:contains('${searchComputerName}')", "href").saveAs("computerURL")))
        .pause(1)
        .exec(http("Select")
          .get("${computerURL}")
          .check(status.is(200)))
        .pause(1)
    }

    object Search05 {

        val feeder = csv("search.csv").random

        val search05 = exec(http("Home")
          .get("/"))
          .pause(1)
          .feed(feeder)
          .exec(http("Search")
            .get("/computers?f=${searchCriterion}")
            .check(css("a:contains('${searchComputerName}')", "href").saveAs("computerURL")))
          .pause(1)
          .exec(http("Select")
            .get("${computerURL}")
            .check(status.is(200)))
          .pause(1)
      }

    object Browse {

        val browse = exec(http("Home")
          .get("/"))
          .pause(2)
          .exec(http("Page 1")
            .get("/computers?p=1"))
          .pause(670 milliseconds)
          .exec(http("Page 2")
            .get("/computers?p=2"))
          .pause(629 milliseconds)
          .exec(http("Page 3")
            .get("/computers?p=3"))
          .pause(734 milliseconds)
          .exec(http("Page 4")
            .get("/computers?p=4"))
          .pause(5)
      }

    object Browse03 {

        val browse03 = exec(http("Home")
          .get("/"))
          .pause(2)
          .exec(http("Page 1")
            .get("/computers?p=1"))
          .pause(670 milliseconds)
          .exec(http("Page 2")
            .get("/computers?p=2"))
          .pause(629 milliseconds)
          .exec(http("Page 3")
            .get("/computers?p=3"))
          .pause(734 milliseconds)
          .exec(http("Page 4")
            .get("/computers?p=4"))
          .pause(5)
      }

       object Browse04 {

          // repeat is a loop resolved at RUNTIME
          val browse04 = repeat(4, "i") { // Note how we force the counter name so we can reuse it
            exec(http("Page ${i}")
              .get("/computers?p=${i}"))
              .pause(1)
          }
        }

        object Browse05 {

            // repeat is a loop resolved at RUNTIME
            val browse05 = repeat(4, "i") { // Note how we force the counter name so we can reuse it
              exec(http("Page ${i}")
                .get("/computers?p=${i}"))
                .pause(1)
            }
          }



  object Edit {

    val headers_10 = Map("Content-Type" -> "application/x-www-form-urlencoded")

    val edit = exec(http("Form")
      .get("/computers/new"))
      .pause(1)
      .exec(http("Post")
        .post("/computers")
        .headers(headers_10)
        .formParam("name", "Beautiful Computer")
        .formParam("introduced", "2012-05-30")
        .formParam("discontinued", "")
        .formParam("company", "37"))
  }

   object Edit03 {

          val headers_10 = Map("Content-Type" -> "application/x-www-form-urlencoded")

          val edit03 = exec(http("Form")
            .get("/computers/new"))
            .pause(1)
            .exec(http("Post")
              .post("/computers")
              .headers(headers_10)
              .formParam("name", "Beautiful Computer")
              .formParam("introduced", "2012-05-30")
              .formParam("discontinued", "")
              .formParam("company", "37"))
      }

   object Edit04 {

       val headers_10 = Map("Content-Type" -> "application/x-www-form-urlencoded")

       val edit04 = exec(http("Form")
         .get("/computers/new"))
         .pause(1)
         .exec(http("Post")
           .post("/computers")
           .headers(headers_10)
           .formParam("name", "Beautiful Computer")
           .formParam("introduced", "2012-05-30")
           .formParam("discontinued", "")
           .formParam("company", "37"))
     }

    object Edit05 {

       // Note we should be using a feeder here

       val headers_10 = Map("Content-Type" -> "application/x-www-form-urlencoded")

       // let's demonstrate how we can retry: let's make the request fail randomly and retry a given number of times

       val edit05 = tryMax(2) { // let's try at max 2 times
         exec(http("Form")
           .get("/computers/new"))
           .pause(1)
           .exec(http("Post")
             .post("/computers")
             .headers(headers_10)
             .formParam("name", "Beautiful Computer")
             .formParam("introduced", "2012-05-30")
             .formParam("discontinued", "")
             .formParam("company", "37")
             .check(status.is(session => 200 + ThreadLocalRandom.current.nextInt(2)))) // we do a check on a condition that's been customized with a lambda. It will be evaluated every time a user executes the request
       }.exitHereIfFailed // if the chain didn't finally succeed, have the user exit the whole scenario
     }

  val httpConf = http
    .baseURL("http://computer-database.gatling.io")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

   val usersA = scenario("UsersA").exec(Search.search, Browse.browse)
   val usersB = scenario("UsersB").exec(Search03.search03, Browse03.browse03)
   val usersC = scenario("UsersC").exec(Search04.search04, Browse04.browse04)
   val usersD = scenario("UsersD").exec(Search05.search05, Browse05.browse05)

   val admins = scenario("Admins").exec(Search.search, Search03.search03, Browse.browse, Browse03.browse03, Edit.edit, Edit03.edit03)
   val adminsB = scenario("AdminsB").exec(Search04.search04, Browse04.browse04, Edit04.edit04)
   val adminsC = scenario("AdminsC").exec(Search05.search05, Browse05.browse05, Edit05.edit05)

   setUp(
     usersA.inject(rampUsers(10) over (10 seconds)),
     usersB.inject(rampUsers(10) over (10 seconds)),
     usersC.inject(rampUsers(10) over (10 seconds)),
     usersD.inject(rampUsers(10) over (10 seconds)),
     admins.inject(rampUsers(2) over (10 seconds)),
     adminsB.inject(rampUsers(2) over (10 seconds)),
     adminsC.inject(rampUsers(2) over (10 seconds))
   ).protocols(httpConf)
}
