package edu.ktu.doggyroomstarter.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.ktu.doggyroomstarter.daos.DogDao
import edu.ktu.doggyroomstarter.models.Dog

@Database(entities = arrayOf(Dog::class), version = 1)
@TypeConverters(edu.ktu.doggyroomstarter.utils.TypeConverters.DogTypeConverter::class)
abstract class DogDatabase : RoomDatabase() {
    abstract fun dogDao(): DogDao
    companion object {
        @Volatile
        private var _instance: DogDatabase? = null
        fun getInstance(context: Context): DogDatabase {
            return _instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DogDatabase::class.java,
                    "dog-db"
                ).build()
                _instance = instance
                instance
            }
        }
    }
}