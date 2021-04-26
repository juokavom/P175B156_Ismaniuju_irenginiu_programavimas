package edu.ktu.doggyroomstarter.utils

import androidx.room.TypeConverter
import edu.ktu.doggyroomstarter.models.DogBreed

annotation class TypeConverters {
    class DogTypeConverter {
        @TypeConverter
        fun dogBreedToInt(dogBreed: DogBreed?): String? {
            return dogBreed?.name
        }
        @TypeConverter
        fun fromDogBreedString(dogBreed: String?): DogBreed? {
            return dogBreed?.let { DogBreed.valueOf(dogBreed) }
        }
    }

}