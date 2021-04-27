package com.sf10.actors

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ActorDao {
    @Insert
    suspend fun insertActor(actor: Actor)

    @Query("SELECT * FROM Actor")
    suspend fun getAll(): List<Actor>

    @Query("SELECT * FROM Actor WHERE birthYear>:year")
    suspend fun getYounger(year: Int): List<Actor>

    @Query("SELECT * FROM Actor WHERE movie LIKE :movie")
    suspend fun getByMovie(movie: String): List<Actor>

    @Delete
    suspend fun deleteActor(actor: Actor)
}