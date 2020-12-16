import Dependencies._
import sbt.project

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.12",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "sushi",
    libraryDependencies ++= gatling
  )

scalacOptions ++= Seq(
  "-language:existentials",
  "-language:implicitConversions",
)


enablePlugins(GatlingPlugin,AssemblyPlugin)

Project.inConfig(Test)(baseAssemblySettings)

assemblyJarName in (Test, assembly) := "Example.jar"

mainClass in (Test, assembly) := Some("io.gatling.app.Gatling")

assemblyMergeStrategy in (Test, assembly) := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"

libraryDependencies ++= Seq(
  "io.grpc" % "grpc-netty" % scalapb.compiler.Version.grpcJavaVersion,
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion
)

libraryDependencies += "com.github.phisgr" %% "gatling-grpc" % "0.10.1" % "test,it"
