libraryDependencies += "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"

appengineSettings

webappResources in Compile := Seq(
  baseDirectory.value / "src/main/webapp"
)

// override def webappClasspath = super.webappClasspath +++ buildLibraryJar 