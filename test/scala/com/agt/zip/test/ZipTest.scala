package com.agt.zip.test

import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.agt.zip.Models.ServiceJsonProtocol._
import com.agt.zip.Models.Zip
import org.scalatest.{Matchers, WordSpec}
import akka.http.scaladsl.model._
import com.agt.zip.RestService

class RestSpec extends WordSpec with Matchers with ScalatestRouteTest with RestService {
  val answer = 10023

  "Zip API" should {
    "Return the right zip code of an address" in {
      val jsonRequest =
        s"""
           |{
           |    "address":"145w 67st NY"
           |}
        """.stripMargin
      val postRequest = HttpRequest(
        HttpMethods.POST,
        uri = "/zip",
        entity = HttpEntity(MediaTypes.`application/json`, jsonRequest))

      postRequest ~> route ~> check {
        responseAs[Zip].shouldEqual(Zip(answer))
      }
    }
  }
}