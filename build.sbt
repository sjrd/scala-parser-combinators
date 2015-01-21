import bintray.Keys.{repository, bintrayOrganization, bintray}

enablePlugins(ScalaJSPlugin)

organization               := "org.scalajs"

name                       := "scala-parser-combinators"

version                    := "1.0.2"

scalaVersion               := "2.11.1"

testFrameworks += new TestFramework("utest.runner.Framework")

libraryDependencies ++= Seq(
  "com.lihaoyi" %%% "utest" % "0.2.5-RC1" % "test"
)

homepage := Some(url("http://www.scala-js.org/"))

licenses += ("BSD New", url("https://github.com/scala-js/scala-js/blob/master/LICENSE"))

repository in bintray := "scala-js-releases"

bintrayOrganization in bintray := Some("scala-js")
