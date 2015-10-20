package com.spark.examples

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

/*
 * This version of linecount example use Spark 1.5.1 version
 */
object LineCount151 {
 def main(args: Array[String]) {
 val logFile = "src/data/inputfile.txt"
 //val sc = new SparkContext("local", "LineCount", "C:\\spark-1.2.1",List("target/scala-2.10/sparkexamples_2.10-1.0.jar"))
 
 val conf = new SparkConf().setAppName("AccumulatorTest").setMaster("local[*]")
 val sc = new SparkContext(conf)
 
 val logData = sc.textFile(logFile, 2).cache()
 val sparkLineCount = logData.filter(line => line.contains("Spark")).count()
 println("===>Lines with Spark words : %s".format(sparkLineCount))
 }
}