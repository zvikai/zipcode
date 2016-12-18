package com.agt.zip

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol


object Models {
  case class Address(address: String)
  case class Zip(zipCode: Int)

  object ServiceJsonProtocol extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val addressFormat = jsonFormat1(Address)
    implicit val zipFormat = jsonFormat(Zip, "zipCode")
  }

}

