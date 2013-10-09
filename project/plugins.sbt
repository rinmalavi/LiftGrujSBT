resolvers := Seq(
  "Instantor Nexus" at "http://www.instantor.com/nexus/content/groups/public/"
, Resolver.url("Instantor Nexus (Ivy)",
    new URL("http://www.instantor.com/nexus/content/groups/public/"))(Resolver.ivyStylePatterns),    
  "NGS Nexus" at "http://ngs.hr/nexus/content/groups/public/"
, Resolver.url("NGS Nexus (Ivy)",
    url("http://ngs.hr/nexus/content/groups/public/"))(Resolver.ivyStylePatterns))

externalResolvers <<= resolvers map { rS =>
  Resolver.withDefaultResolvers(rS, mavenCentral = false)
}

// +-------------------------------------------------------------------------------------+
// | XSBT Web plugin (https://github.com/siasia/xsbt-web-plugin)                         |
// | Implements SBT 0.7.x Web project actions: "jetty-run" -> "container:start", etc ... |
// +-------------------------------------------------------------------------------------+

addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "0.4.2")

// +-------------------------------------------------------------------------------------+
// | CoffeeScripted SBT (https://github.com/softprops/coffeescripted-sbt)                |
// | Automates "compilation" of coffeescript files (/src/main/*.coffee) into javascript  |
// |                                                                                     |
// | See also: Coffeescript reference (http://jashkenas.github.com/coffee-script/)       |
// +-------------------------------------------------------------------------------------+


addSbtPlugin("me.lessis" % "coffeescripted-sbt" % "0.2.3")

// +-------------------------------------------------------------------------------------+
// | Less SBT (https://github.com/softprops/less-sbt)                                    |
// | Automates "compilation" of less files (/src/main/*.less) into css                   |
// |                                                                                     |
// | See also: LESS reference (http://lesscss.org/)                                      |
// +-------------------------------------------------------------------------------------+

//addSbtPlugin("me.lessis" % "less-sbt" % "0.2.1")

// +------------------------------------------------------------------------------------+
// | SBT Eclipse (https://github.com/typesafehub/sbteclipse)                            |
// | Creates .project and .classpath files for easy Eclipse project imports             |
// |                                                                                    |
// | See also: Eclipse downloads (http://www.eclipse.org/downloads/)                    |
// | See also: Scala IDE downloads (http://download.scala-ide.org/)                     |
// +------------------------------------------------------------------------------------+

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.3.0")

// +-------------------------------------------------------------------------------------+
// | SBT Assembly (https://github.com/sbt/sbt-assembly)                                  |
// | Creates single jar releases from multiple projects                                  |
// +-------------------------------------------------------------------------------------+

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.9.1")

// +-------------------------------------------------------------------------------------+
// | Dependency graph SBT plugin (https://github.com/jrudolph/sbt-dependency-graph)      |
// | Lists all library dependencies in a nicely formatted way for easy inspection.       |
// +-------------------------------------------------------------------------------------+

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")


//// Orr:
//
// addSbtPlugin("com.orrsella" % "sbt-sublime" % "1.0.6")
//
// addSbtPlugin("com.orrsella" % "sbt-stats" % "1.0.3")
//
// addSbtPlugin("com.orrsella" % "sbt-sound" % "1.0.2")
//
//// Toni:
//
// addSbtPlugin("com.typesafe.sbt" % "sbt-s3" % "0.5")
//
//// Gerolf:
//
// addSbtPlugin("com.github.gseitz" % "sbt-protobuf" % "0.3.0")
//
// addSbtPlugin("com.github.gseitz" % "sbt-release" % "0.7.1")
//
//// Johannes:
//
// addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.1")
//
//// Perry:
//
// addSbtPlugin("com.hanhuy.sbt" % "android-sdk-plugin" % "0.8.0")
//
//// Esko:
// 
// addSbtPlugin("fi.jumi.sbt" % "sbt-jumi" % "0.1.0")
//
//// Marko:
//
// resolvers += "Element Releases" at "http://repo.element.hr/nexus/content/repositories/releases/"
//
// addSbtPlugin("hr.element.xsbt" % "xsbt-sh" % "0.0.1")
//
//// Roman:
//
// addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.2")
//
//// Erlend:
//
// addSbtPlugin("no.arktekk.sbt" % "aether-deploy" % "0.10")
//
//// Mikko:
//
// resolvers += Opts.resolver.sonatypeSnapshots
//
// addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.1")
//
//// Josh:
//
// addSbtPlugin("com.typesafe.sbt" % "sbt-pgp" % "0.8.1")
//
// addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.6.0")
//
//
// // for sbt-git and sbt-ghpages
// resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"
//
// addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.6.2")
//
//// Heiko:
//
// addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.3.0")
//
// addSbtPlugin("name.heikoseeberger" % "sbt-groll" % "1.6.0")
//
// addSbtPlugin("com.typesafe.sbt" % "sbt-osgi" % "0.6.0")
//
// addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.1.0")
//
//// Peter:
//
// addSbtPlugin("com.typesafe.sbt" % "sbt-proguard" % "0.2.2")
//
// addSbtPlugin("com.typesafe.sbt" % "sbt-aspectj" % "0.9.2")
//
// addSbtPlugin("com.typesafe.sbt" % "sbt-atmos" % "0.1.2")
//
//// Doug:
//
// addSbtPlugin("me.lessis" % "np" % "0.2.0")
//
// addSbtPlugin("me.lessis" % "ls-sbt" % "0.1.3")
//
// addSbtPlugin("me.lessis" % "jot" % "0.1.0")
//
// addSbtPlugin("me.lessis" % "less-sbt" % "0.2.0")
//
// addSbtPlugin("me.lessis" % "coffeescripted-sbt" % "0.2.3")
//
// addSbtPlugin("me.lessis" % "sbt-growl-plugin" % "0.1.3")
//
//
// resolvers += Resolver.url(
//   "bintray-sbt-plugin-releases",
//     url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(
//         Resolver.ivyStylePatterns)
//
// addSbtPlugin("me.lessis" % "bintray-sbt" % "0.1.1")
//
// addSbtPlugin("me.lessis" % "cappi" % "0.1.1")
//
//// Eugene:
//
// addSbtPlugin("com.eed3si9n" % "sbt-unidoc" % "0.2.0")
//
// addSbtPlugin("org.scalaxb" % "sbt-scalaxb" % "1.1.1")
// 
// addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.9.1")
//
// addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.2.5")
//
// addSbtPlugin("com.eed3si9n" % "sbt-dirty-money" % "0.1.0")
//
// addSbtPlugin("com.eed3si9n" % "sbt-scalashim" % "0.2.2")
//
// addSbtPlugin("com.eed3si9n" % "sbt-man" % "0.1.1")
//
// addSbtPlugin("com.eed3si9n" % "sbt-appengine" % "0.6.0")



