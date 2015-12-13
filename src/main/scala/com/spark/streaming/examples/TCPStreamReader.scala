package com.spark.streaming.examples

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._
object TCPStreamReader {
  def main(args: Array[String]) {

    /**
     * @author rashmitr
     */

    if (args.length < 2) {
      System.err.println("Usage: TCPStreamReader <host> <port>")
      System.exit(1)
    }
    val hostname = args(0).trim
    val portnum = args(1).toInt
    val appName = "Stream example 2"
    val conf = new SparkConf()
    conf.setAppName(appName)
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(10))

    val rawDstream = ssc.socketTextStream(hostname, portnum)

    val wordCount = rawDstream
      .flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
      .map(item => item.swap)
      .transform(rdd => rdd.sortByKey(false))
      .foreachRDD(rdd =>
        {
          rdd.take(10).foreach(x => println("List : " + x))
        })

    ssc.start()
    ssc.awaitTermination()
  } // end main
} // end stream2
  
