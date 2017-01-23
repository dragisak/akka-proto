name := "akka-proto"

version := "1.0"

scalaVersion := "2.12.1"

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

val akkaVersion = "2.4.16"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.1.9",
  // If you need scalapb/scalapb.proto or anything from
  // google/protobuf/*.proto
  // "com.trueaccord.scalapb" %% "scalapb-runtime" % com.trueaccord.scalapb.compiler.Version.scalapbVersion % "protobuf",
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
  "org.scalatest" %% "scalatest" % "3.0.1" % Test

)

initialCommands in console :=
  """
    |import com.dragishak._
    |import com.dragishak.messages._
    |import akka.actor._
    |import akka.pattern._
    |import akka.util._
    |import scala.concurrent._
    |import scala.concurrent.duration._
    |
    |val system = ActorSystem("me")
    |val actor = system.actorOf(PingActor.props, "ping")
    |implicit val to = Timeout(1.second)
    |implicit val ctx = system.dispatcher
    |
    |""".stripMargin