package com.dragishak

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest._
import Matchers._
import com.dragishak.messages._

import scala.concurrent.duration._

class PingActorSpec extends TestKit(ActorSystem("PingActorSpec")) with ImplicitSender
  with WordSpecLike with BeforeAndAfterAll {

  override def afterAll {
    TestKit.shutdownActorSystem(system)
  }


  "PingActor" should {

    val actor = system.actorOf(PingActor.props)

    "receive Protobuf message" in {

      actor ! Person("Dragisa", "Krsmanovic")

      expectMsg(1.second, "Thank you Dragisa Krsmanovic")

    }
  }
}
