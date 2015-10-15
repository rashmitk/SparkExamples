package com.spark.examples

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object BroadcastVarTest extends App{
  val itemsToShipFile = "src/data/itemsToShip.txt"

  val conf = new SparkConf().setAppName("BroadcastVarTest").setMaster("local")
  val sc = new SparkContext(conf)

  
  val packageShipmentRates = sc.parallelize(Seq(("mobilephone", 10), ("laptop", 10), ("watch", 10), ("lenovophone", 10), ("applephone", 10), ("juicer", 10), ("camera", 10), ("led", 10), ("wristband", 10))).collect().toMap
  val broadcastRates = sc.broadcast(packageShipmentRates)
  
  val itemsToShip = sc.textFile(itemsToShipFile)
  
  val shippingCostPerItems = itemsToShip.map(shipType=>(shipType,1)).reduceByKey(_+_).map{case (shipType,numberOfPackages) => (shipType,numberOfPackages * broadcastRates.value(shipType))}.collect()
  
  println("BroadcastVarTest ============> totalShippingCost :\n\n")
  
  shippingCostPerItems.foreach(tuple => println("Item: "+tuple._1+", cost:"+tuple._2))
}