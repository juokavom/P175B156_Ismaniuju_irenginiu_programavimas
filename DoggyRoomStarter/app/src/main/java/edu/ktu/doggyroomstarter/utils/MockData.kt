package edu.ktu.doggyroomstarter.utils

import edu.ktu.doggyroomstarter.R
import edu.ktu.doggyroomstarter.models.Dog
import edu.ktu.doggyroomstarter.models.DogBreed
import kotlin.random.Random

object MockData {
    val dogs = listOf(
        Dog(
            0,
            "Sparky",
            5,
            DogBreed.GERMAN_SHEPHERD,
            R.drawable.german_shepherd_192
        ),
        Dog(
            0,
            "Brian",
            7,
            DogBreed.LABRADOR_RETRIEVER,
            R.drawable.labrador_retriever_192
        ),
        Dog(
            0,
            "Walter",
            1,
            DogBreed.GOLDEN_RETRIEVER,
            R.drawable.golden_retriever_192
        )
    )

    fun getRandomDog(): Dog = dogs[Random.nextInt(0, dogs.size)]
}