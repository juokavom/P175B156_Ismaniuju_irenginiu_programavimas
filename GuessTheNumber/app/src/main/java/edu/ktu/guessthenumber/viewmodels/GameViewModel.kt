package edu.ktu.guessthenumber.viewmodels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.ktu.guessthenumber.databinding.FragmentGameBinding
import java.util.*
import kotlin.random.Random

class GameViewModel : ViewModel() {
    val minRange = 1
    val maxRange = 100
    val maxAttempts = 7
    val number = Random.nextInt(minRange, maxRange)

    private val _attemptsRemaining = MutableLiveData<Int>()
    val attemptsRemaining : LiveData<Int>
        get() = _attemptsRemaining

    private val _guessedNumber = MutableLiveData<Int>()
    val guessedNumber : LiveData<Int>
        get() = _guessedNumber

    private val _guessResult = MutableLiveData<Int>()
    val guessResult : LiveData<Int>
        get() = _guessResult

    init{
        _attemptsRemaining.value = maxAttempts
    }
}