package com.spark.examples

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object WordCount {
  def main(args: Array[String]) {
    val logFile = "/home/inputfile.txt"

    val conf = new SparkConf()
    conf.set("spark.app.name", "WordCount_Application")
    //conf.set("spark.master", "master")

    //val sc = new SparkContext("local", "WordCount", "C:\\spark-1.5.1-hadoop2.6",List("target/scala-2.10/sparkexamples_2.10-1.0.jar"))
    //val sc = new SparkContext("master", "WordCount", "C:\\spark-1.2.1", List("target/scala-2.10/sparkexamples_2.10-1.0.jar"))

    val sc = new SparkContext(conf)
    val logFileLines = sc.textFile(logFile, 2).cache()

    val logFileWords = logFileLines.flatMap(line => line.split(" "))

    // This is slower version of counting words than below solution
    //val logFileWordCountSlower = logFileWords.map(word => (word, 1)).reduceByKey((x,y) => x + y)
    //logFileWordCountSlower.foreach(word => println(word._1 +"-"+word._2) )

    // This is faster version of counting words
    val logFileWordCountFaster = logFileWords.map(word => (word, 1)).countByValue()
    logFileWordCountFaster.foreach(word => println(word._1 + " " + word._2))

  }
}