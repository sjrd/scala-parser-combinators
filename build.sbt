import bintray.Keys.{repository, bintrayOrganization, bintray}

scalaJSSettings

organization               := "org.scalajs"

name                       := "scala-parser-combinators"

version                    := "1.0.2"

scalaVersion               := "2.11.1"

utest.jsrunner.Plugin.utestJsSettings

homepage := Some(url("http://www.scala-js.org/"))

licenses += ("BSD New", url("https://github.com/scala-js/scala-js/blob/master/LICENSE"))

repository in bintray := "scala-js-releases"

bintrayOrganization in bintray := Some("scala-js")
