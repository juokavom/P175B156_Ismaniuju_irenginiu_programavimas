package edu.ktu.doggyroomstarter.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import edu.ktu.doggyroomstarter.models.Dog
import java.util.concurrent.Flow

@Dao
interface DogDao {
    @Query("SELECT * FROM dogs")
    fun getAllDogs(): kotlinx.coroutines.flow.Flow<List<Dog>>

    @Insert
    suspend fun insertAll(vararg dog: Dog)

    @Delete
    suspend fun delete(dog: Dog)
}