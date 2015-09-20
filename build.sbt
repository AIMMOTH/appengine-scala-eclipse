name := "sbt-appengine"

version := "1.0"

// Use 2.10.X since GAE runs in Java 7

scalaVersion := "2.10.5"

libraryDependencies ++= Seq(
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "org.json4s" %% "json4s-native" % "3.2.11",
  "org.glassfish.jersey.containers" % "jersey-container-servlet-core" % "2.18",
  "com.auth0" % "java-jwt" % "2.0.1",
  "commons-codec" % "commons-codec" % "1.4"
)

// APPENGINE_SDK_HOME is set to run sbt-appengine but doesn't include tools!

val toolsJar : File = file(System.getenv("APPENGINE_SDK_HOME") + "/lib/appengine-tools-api.jar")

unmanagedJars in Compile += toolsJar
