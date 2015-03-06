enablePlugins(ScalaJSPlugin)

organization               := "org.scala-js"

name                       := "scala-parser-combinators"

version                    := "1.0.2"

scalaVersion               := "2.11.1"

testFrameworks += new TestFramework("utest.runner.Framework")

libraryDependencies ++= Seq(
  "com.lihaoyi" %%% "utest" % "0.3.0" % "test"
)

homepage := Some(url("http://scala-js.org/"))

licenses += ("BSD 3-Clause", url("http://opensource.org/licenses/BSD-3-Clause"))

scmInfo := Some(ScmInfo(
    url("https://github.com/sjrd/scala-parser-combinators"),
    "scm:git:git@github.com:sjrd/scala-parser-combinators.git",
    Some("scm:git:git@github.com:sjrd/scala-parser-combinators.git")))

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := (
  <developers>
    <developer>
      <id>sjrd</id>
      <name>Sébastien Doeraene</name>
      <url>https://github.com/sjrd/</url>
    </developer>
  </developers>
)

pomIncludeRepository := { _ => false }
