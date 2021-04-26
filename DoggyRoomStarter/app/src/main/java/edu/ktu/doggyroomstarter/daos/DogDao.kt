package edu.ktu.doggyroomstarter.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import edu.ktu.doggyroomstarter.models.Dog

@Dao
interface DogDao {
    @Query("SELECT * FROM dogs")
    suspend fun getAllDogs(): List<Dog>

    @Insert
    suspend fun insertAll(vararg dog: Dog)

    @Delete
    suspend fun delete(dog: Dog)
}