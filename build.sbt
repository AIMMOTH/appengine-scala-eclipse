name := "sbt-appengine"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "net.databinder" %% "unfiltered-filter" % "0.8.0",
  "org.json4s" %% "json4s-native" % "3.2.11"
)

// APPENGINE_SDK_HOME is set to run sbt-appengine but doesn't include tools!

val toolsJar : File = file(System.getenv("APPENGINE_SDK_HOME") + "/lib/appengine-tools-api.jar")

unmanagedJars in Compile += toolsJar
