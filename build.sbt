lazy val jna = "net.java.dev.jna" % "jna" % "4.5.0"
lazy val jnaPlatform = "net.java.dev.jna" % "jna-platform" % "4.5.0"
lazy val junitInterface = "com.novocode" % "junit-interface" % "0.11"

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      version := "1.0.1",
      organization := "ch.epfl.scala",
      organizationName := "Scala Center",
      organizationHomepage := Some(url("http://scala.epfl.ch/")),
      homepage := scmInfo.value map (_.browseUrl),
      scmInfo := Some(ScmInfo(url("https://github.com/scalacenter/ipcsocket"), "git@github.com:scalacenter/ipcsocket.git")),
      developers := List(
        Developer("eed3si9n", "Eugene Yokota", "@eed3si9n", url("https://github.com/eed3si9n")),
        Developer("jvican", "Jorge Vicente Cantero", "@jvican", url("https://github.com/jvican"))
      ),
      isSnapshot := (isSnapshot or version(_ endsWith "-SNAPSHOT")).value,
      description := "IPC: Unix Domain Socket and Windows Named Pipes for Java",
      licenses := Seq("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt")),
      publishTo := {
        val nexus = "https://oss.sonatype.org/"
        if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
        else Some("releases" at nexus + "service/local/staging/deploy/maven2")
      }
    )),
    name := "ipcsocket",
    libraryDependencies ++= Seq(jna, jnaPlatform, junitInterface % Test),
    crossPaths := false,
    autoScalaLibrary := false,
  )
