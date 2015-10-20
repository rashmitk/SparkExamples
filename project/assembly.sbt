//addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.0")
//addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.2")


resolvers += Resolver.url("bintray-sbt-plugins", url("http://dl.bintray.com/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)
//resolvers += "Bintray sbt plugin releases" at "http://dl.bintray.com/sbt/sbt-plugin-releases/"

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.0")