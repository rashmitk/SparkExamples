package com.spark.examples

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
 
object WordCount {
 def main(args: Array[String]) {
 val logFile = "src/data/inputfile.txt"
 val sc = new SparkContext("local", "WordCount", "C:\\spark-1.2.1",List("target/scala-2.10/sparkexamples_2.10-1.0.jar"))
 val logFileLines = sc.textFile(logFile, 2).cache()

 val logFileWords = logFileLines.flatMap(line => line.split(" "))
 
 //logFileWords.foreach(word => println("==> "+word))
 
 val logFileWordCount = logFileWords.map(word => (word, 1)).reduceByKey((x,y) => x + y)
 
 logFileWordCount.foreach(word => println(word._1 +"-"+word._2) )
 }
}