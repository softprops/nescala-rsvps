organization := "nescala"

name := "nescala-rsvps"

version := "0.1.0-SNAPSHOT"

seq(coffeeSettings: _*)

(resourceManaged in (Compile, CoffeeKeys.coffee)) <<= (
  crossTarget in Compile)(_ / "classes" / "www" / "js")

libraryDependencies ++= Seq(
   "net.liftweb" %% "lift-json" % "2.4-M4",
   "net.databinder" %% "unfiltered-netty-server" % "0.6.1",
   "net.databinder.dispatch" %% "core" % "0.9.0-alpha2",
   "org.clapper" %% "avsl" % "0.3.6",
   "net.databinder" %% "unfiltered-spec" % "0.6.1" % "test"
)

resolvers ++= Seq(
  "jboss repo" at "http://repository.jboss.org/nexus/content/groups/public-jboss/"
)
