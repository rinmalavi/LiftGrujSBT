import sbt._
import Keys._

import Dependencies._
import Default._

import com.earldouglas.xsbtwebplugin.PluginKeys._
import com.earldouglas.xsbtwebplugin.WebPlugin._
object MockHttpStatus extends Build {
  lazy val root = Project(
    "SandServer"
  , file("SandServer")
  , settings = Default.settings ++ webSettings ++ Seq(
      libraryDependencies := Seq(liftWebkit, jetty, spec2, junit)
    , port in container.Configuration := 7777
    , artifactName in packageWar := ((_: ScalaVersion, _: ModuleID, _: Artifact) => "mock.war")
    )
  )
}

import com.typesafe.sbteclipse.plugin.EclipsePlugin.{settings => eclipseSettings, _}
import net.virtualvoid.sbt.graph.Plugin.graphSettings

object Default {

  val settings =
    Defaults.defaultSettings ++
    eclipseSettings ++
    graphSettings ++ Seq(
      javaHome := sys.env.get("JDK16_HOME").map(file(_))
    , javacOptions := Seq(
        "-deprecation"
      , "-encoding", "UTF-8"
      , "-Xlint:unchecked"
      , "-source", "1.6"
      , "-target", "1.6"
      )

    , crossScalaVersions := Seq("2.10.2")
    , scalaVersion := crossScalaVersions.value.last
    , scalacOptions := Seq(
        "-unchecked"
      , "-deprecation"
      , "-optimise"
      , "-encoding", "UTF-8"
      , "-Xcheckinit"
      , "-Yclosure-elim"
      , "-Ydead-code"
      , "-Yinline"
      , "-Xmax-classfile-name", "72"
      ,  "-Yrepl-sync"
      , "-Xlint"
      , "-Xverify"
      , "-Ywarn-all"
      ,  "-Yinline-warnings"
      , "-feature"
      , "-language:postfixOps"
      , "-language:implicitConversions"
      , "-language:existentials"
      )
    , scalacOptions in Test ++= Seq("-Yrangepos")

    , unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil
    , unmanagedSourceDirectories in Test := (scalaSource in Test).value :: Nil

    , EclipseKeys.projectFlavor := EclipseProjectFlavor.Scala
    , EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
    )
}

object Dependencies {

  val jetty   = "org.eclipse.jetty" % "jetty-webapp" % "7.6.5.v20120716" % "container"
  // "org.eclipse.jetty.orbit" % "javax.servlet" % "2.5.0.v201103041518" % "container" artifacts (Artifact("javax.servlet", "jar", "jar"))
  
  private val liftVersion = "2.5"
  val liftCommon = "net.liftweb" %% "lift-common" % liftVersion
  val liftUtil   = "net.liftweb" %% "lift-util"   % liftVersion
  val liftWebkit = "net.liftweb" %% "lift-webkit" % liftVersion

  val scalaIo   = "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.0"
  
  val spec2     = "org.specs2" %% "specs2" % "2.1.1" % "test"
  val junit     = "junit" % "junit" % "4.11" % "test"
}
