package edu.ktu.doggyroomstarter.models

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

enum class DogBreed(val breedName: String){
    GERMAN_SHEPHERD("German Shepherd"),
    LABRADOR_RETRIEVER("Labrador Retriever"),
    GOLDEN_RETRIEVER("Golden Retriever"),
}

@Entity(tableName = "dogs")
data class Dog (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val age: Int,
    val breed: DogBreed,
    @DrawableRes val image: Int
)