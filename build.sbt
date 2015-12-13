name := "SparkExamples"
version := "1.0"
scalaVersion := "2.10.4"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.1" % "provided"

libraryDependencies += "org.apache.spark" %% "spark-streaming" % "1.5.1"
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka" % "1.5.1"
libraryDependencies += "org.apache.spark" %% "spark-streaming-flume" % "1.5.1"
libraryDependencies += "org.apache.spark" %% "spark-streaming-twitter" % "1.5.1"
libraryDependencies += "org.apache.spark" %% "spark-streaming-zeromq" % "1.5.1"

assemblyJarName in assembly := "sparkexamples.jar"
