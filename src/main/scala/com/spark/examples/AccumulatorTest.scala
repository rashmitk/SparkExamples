package com.spark.examples

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object AccumulatorTest extends App{
  
 
 val inputFile = "src/data/accu_input.txt"
 
 val conf = new SparkConf().setAppName("AccumulatorTest").setMaster("local")
 val sc = new SparkContext(conf)
 
 val inputData = sc.textFile(inputFile)
 
 val accum = sc.accumulator(0, "My Accumulator")
 
 inputData.filter(_.contains("error")).foreach(x=>accum+=1)
 
 println("======== Success ======== accumValue:"+accum.value)
 
}