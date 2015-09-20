App Engine Scala Template (with Java and Eclipse)
=================================================

A template project with Scala and Unfiltered on Google App Engine.

* Scala
* Java
* [Unfiltered filter](http://unfiltered.databinder.net)
* [JSON4S](https://github.com/json4s/json4s)
* Eclipse
* sbt
  * Scalate precompiling support with [xsbt-scalate-generate](https://github.com/backchatio/xsbt-scalate-generate)
  * App Engine support with [sbt-appengine](https://github.com/sbt/sbt-appengine)

Install
-------

1) Download and set path to appengine sdk

Prepare
-------

Java 7 or later is required.

Install App Engine SDK (mandatory) and JRebel (recommended).

```bash
gcloud components update gae-java
```

Set environment variables in `.bashrc` or `.zshrc`.

```bash
export APPENGINE_SDK_HOME=$HOME/Library/google-cloud-sdk/platform/appengine-java-sdk
export JREBEL_PATH=$HOME/Library/jrebel/jrebel.jar
```

Run
---

Run sbt.

```bash
sbt
```

Start the development server.

```
appengineDevServer --port=8888
```

Deploy
------

Run sbt.

```bash
sbt
```

Start the development server.

```
appengineDeploy --oauth2
```

Eclipse
-------

1) Run

```
sbt eclipse
```

2) Import Eclipse project in Eclipse

3) Add Google App Engine to project

3.1) Quick fix output folder to WEB-INF/classes
3.2) Quick fix copy jersey jars to WEB-INF/lib
3.3) Ignore any JPA persistence.xml error
3.4) Delete jar files appengine-stubs and appengine-testing from WEB-INF/lib

4) Use JDK for compilation

5) You may only upload if compiled with Java 7

Structure
---------

* `src/main/scala/` - Scala sources of the product
* `src/main/java/` - Java sources of the product
* `src/test/scala/` - Scala sources of the test
* `src/main/webapp/` - Web app source
* `build.sbt` - Scala dependencies
* `project/plugins.sbt` - Eclipse SBT plugin
* `appengine.sbt` - App Engine dependencies

Credits
-------

Forked from https://github.com/int128/appengine-scala-starter

Which is forked from https://github.com/sbt/sbt-appengine

Thanks!