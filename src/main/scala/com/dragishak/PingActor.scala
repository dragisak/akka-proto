package com.dragishak

import akka.actor.{Actor, ActorLogging, Props}

import com.dragishak.messages._

class PingActor extends Actor with ActorLogging {
  override def receive: Receive = {


    case s: String => sender() ! s"Hello $s"

    case Person(firstName, lastName) => sender() ! s"Thank you $firstName $lastName"

  }
}

object PingActor {
  val props = Props[PingActor]
}