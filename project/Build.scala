import sbt._
import Keys._

object BuildSettings {
  val buildOrganization = "dualitystudios"
  val buildVersion      = "0.1"
  val buildScalaVersion = "2.9.1"

  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization := buildOrganization,
    version      := buildVersion,
    scalaVersion := buildScalaVersion
  )
}

object Dependencies {

	val liftVersion = "2.4"
	val logbackVer = "0.9.26"
  
	val lift_webkit = "net.liftweb" %% "lift-webkit" % liftVersion % "compile"
	val lift_mapper = "net.liftweb" %% "lift-mapper" % liftVersion % "compile"
	val jetty = "org.mortbay.jetty" % "jetty" % "6.1.26" % "test"
	val junit = "junit" % "junit" % "4.7" % "test"
	val testing_tools = "org.scala-tools.testing" %% "specs" % "1.6.9" % "test"
  val logbackclassic = "ch.qos.logback" % "logback-classic"  % logbackVer
	
	val liftAuth = RootProject(uri("git://github.com/keynan/LiftAthentication.git"))
}


object Resolvers {
  val scala_testing = "Scala Testing" at "http://mvnrepository.com/artifact"
	def resolve_all = Seq(scala_testing)
}

object LiftProject extends Build {
	
	import Dependencies._;
  import BuildSettings._;
	import Resolvers._;
	
  lazy val JavaNet = "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

	lazy val main = Project (
    "LiftAuthExample",
    file ("."),
    settings = buildSettings ++ Seq (
			resolvers := resolve_all, 
			libraryDependencies ++= Seq(
				lift_webkit,
				lift_mapper,
				jetty,
				junit,
				testing_tools,
				logbackclassic
				
			)) 
  ) dependsOn(liftAuth)

  
}
