package com.spark.examples

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object WordCountFromList {
  def main(args: Array[String]) {

    val conf = new SparkConf()
    conf.set("spark.app.name", "WordCount_Application")
    val sc = new SparkContext(conf)
    
    
    val wordList = List("the","number","of","tasks","already","submitted","the","setting","number","already","the")
    
    val wordRDD = sc.parallelize(wordList)

    val logFileWordCountFaster = wordRDD.map(word => (word, 1)).countByValue()
    logFileWordCountFaster.foreach(word => println(word._1 + " " + word._2))

  }
}