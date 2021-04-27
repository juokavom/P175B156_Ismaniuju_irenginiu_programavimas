package com.sf10.actors
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Actor::class), version = 1)
abstract class ActorDatabase : RoomDatabase() {

    abstract fun actorDao(): ActorDao
}