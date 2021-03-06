package com.spark.examples

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
 
object LineCount {
 def main(args: Array[String]) {
 val logFile = "src/data/inputfile.txt"
 val sc = new SparkContext("local", "LineCount", "C:\\spark-1.2.1",List("target/scala-2.10/sparkexamples_2.10-1.0.jar"))
 val logData = sc.textFile(logFile, 2).cache()
 val sparkLineCount = logData.filter(line => line.contains("Spark")).count()
 println("===>Lines with Spark words : %s".format(sparkLineCount))
 }
}