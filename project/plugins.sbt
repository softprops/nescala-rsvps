addSbtPlugin("me.lessis" % "coffeescripted-sbt" % "0.2.2")

resolvers += Resolver.url("sbt-plugin-releases",
  new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(
    Resolver.ivyStylePatterns)
