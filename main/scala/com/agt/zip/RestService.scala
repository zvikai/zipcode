package com.agt.zip

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.agt.zip.Models.{Address, Zip}
import com.agt.zip.Models.ServiceJsonProtocol._


trait RestService {
  implicit val system: ActorSystem
  implicit val materializer: ActorMaterializer

  val route =
    path("zip") {
      post {
        entity(as[Address]) {
          address => complete {
            Zip(10023)
          }
        }
      }
    }
}