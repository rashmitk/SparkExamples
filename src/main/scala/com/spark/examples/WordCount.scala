package com.spark.examples

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
 
object WordCount {
 def main(args: Array[String]) {
 val logFile = "src/data/inputfile.txt"
 val sc = new SparkContext("local", "WordCount", "C:\\spark-1.2.1",List("target/scala-2.10/sparkexamples_2.10-1.0.jar"))
 val logFileLines = sc.textFile(logFile, 2).cache()

 val logFileWords = logFileLines.flatMap(line => line.split(" "))
 
 // This is slower version of counting words than below solution
 //val logFileWordCountSlower = logFileWords.map(word => (word, 1)).reduceByKey((x,y) => x + y)
 //logFileWordCountSlower.foreach(word => println(word._1 +"-"+word._2) )
 
 // This is faster version of counting words
 val logFileWordCountFaster = logFileWords.map(word => (word, 1)).countByValue()
 logFileWordCountFaster.foreach( word => println(word._1 +" "+word._2))
 
 }
}