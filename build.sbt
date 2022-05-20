ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "my-zip"
  )
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.12"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % Test
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.16.0" % Test
libraryDependencies += "org.scalatestplus" %% "scalacheck-1-16" % "3.2.12.0" % Test
