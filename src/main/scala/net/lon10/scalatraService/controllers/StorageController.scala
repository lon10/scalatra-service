package net.lon10.scalatraService.controllers

import net.lon10.scalatraService.ScalatraserviceStack
import com.mongodb.casbah.Imports._

class StorageController(storageCollection: MongoCollection) extends ScalatraserviceStack {
  post("/") {
    val pair = MongoDBObject(params("key") -> params("value"))
    storageCollection += pair
  }

  get("/") {
    storageCollection.find()
    for { x <- storageCollection} yield x
  }
}