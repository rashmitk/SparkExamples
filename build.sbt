name := "SparkExamples"
 
version := "1.0"
 
scalaVersion := "2.10.4"

//libraryDependencies += "org.apache.spark" %% "spark-core" % "0.9.1"



//scalaVersion := "2.10.4"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.1" % "provided"

assemblyJarName in assembly := "sparkexamples.jar"


 
//resolvers += "Akka Repository" at "http://repo.akka.io/releases/"