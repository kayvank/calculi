lazy val root = (project in file("."))
  .settings(
    organization := "q2io",
    name := "calculi",
    scalaVersion := "2.12.6",
    scalacOptions += "-Ypartial-unification",
    libraryDependencies ++= {
      object V {
        val spec2="4.2.0"
        val logback="1.2.3"
        val http4s="0.18.12"
        val circe="0.9.3"
        val cats_effect="1.0.0-RC2"
      }
      Seq(
        "io.circe" %% "circe-core" %  V.circe,
        "io.circe" %% "circe-generic" %  V.circe,
        "io.circe" %% "circe-parser" %  V.circe,
        "org.http4s" %% "http4s-blaze-server" % V.http4s,
        "org.http4s" %% "http4s-circe" % V.http4s,
        "org.http4s" %% "http4s-dsl" % V.http4s,
        "org.specs2" %% "specs2-core" % V.spec2 % "test",
        "org.typelevel" %% "cats-effect" % V.cats_effect,
        "ch.qos.logback" % "logback-classic" % V.logback
      )
    }
  )

enablePlugins(UniversalPlugin)

enablePlugins(DockerPlugin)
