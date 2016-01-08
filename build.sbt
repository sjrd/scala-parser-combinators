import com.typesafe.tools.mima.plugin.{MimaPlugin, MimaKeys}

lazy val `scala-parser-combinators` = crossProject.in(file(".")).
  settings(scalaModuleSettings: _*).
  jvmSettings(
    name := "scala-parser-combinators-jvm"
  ).
  jsSettings(
    name := "scala-parser-combinators-js"
  ).
  settings(
    moduleName         := "scala-parser-combinators",
    version            := "1.0.5-SNAPSHOT",
    scalaVersion       := crossScalaVersions.value.head,
    crossScalaVersions := Seq("2.11.7", "2.12.0-M3")
  ).
  jvmSettings(
    // important!! must come here (why?)
    scalaModuleOsgiSettings: _*
  ).
  jvmSettings(
    OsgiKeys.exportPackage := Seq(s"scala.util.parsing.*;version=${version.value}"),

    // needed to fix classloader issues (see scala-xml#20)
    fork in Test := true
  ).
  jsSettings(
    // Scala.js cannot run forked tests
    fork in Test := false
  ).
  jsConfigure(_.enablePlugins(ScalaJSJUnitPlugin)).
  jvmSettings(
    libraryDependencies += "junit" % "junit" % "4.11" % "test",
    libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"
  ).
  jvmSettings(
    mimaPreviousVersion := Some("1.0.2")
  ).
  jsSettings(
    mimaPreviousVersion := None // 1.0.2 was not yet published for Scala.js
  )

lazy val `scala-parser-combinatorsJVM` = `scala-parser-combinators`.jvm
lazy val `scala-parser-combinatorsJS` = `scala-parser-combinators`.js
