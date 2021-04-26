package edu.ktu.doggyroomstarter.models

import androidx.annotation.DrawableRes

enum class DogBreed(val breedName: String){
    GERMAN_SHEPHERD("German Shepherd"),
    LABRADOR_RETRIEVER("Labrador Retriever"),
    GOLDEN_RETRIEVER("Golden Retriever"),
}

data class Dog (
    val id: Int,
    val name: String,
    val age: Int,
    val breed: DogBreed,
    @DrawableRes val image: Int
)