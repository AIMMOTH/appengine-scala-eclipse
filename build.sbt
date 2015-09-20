name := "sbt-appengine"

version := "1.0"

scalaVersion := "2.10.5"

libraryDependencies ++= Seq(
  "javax.servlet" % "servlet-api" % "2.5" % "provided",
  "net.databinder" %% "unfiltered-filter" % "0.8.0",
  "org.json4s" %% "json4s-native" % "3.2.11",
  "org.glassfish.jersey.containers" % "jersey-container-servlet-core" % "2.18"
)

// APPENGINE_SDK_HOME is set to run sbt-appengine but doesn't include tools!

val toolsJar : File = file(System.getenv("APPENGINE_SDK_HOME") + "/lib/appengine-tools-api.jar")

unmanagedJars in Compile += toolsJar

// val commonSettings = packSettings ++ Seq(
//     scalaVersion := "2.10.5",
//     version := "0.1",
//     crossPaths := false,
//     packCopyDependenciesTarget := target.value / "WEB-INF/lib"
//   )
