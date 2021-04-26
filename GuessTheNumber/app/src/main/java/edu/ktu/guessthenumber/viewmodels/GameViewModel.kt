package edu.ktu.guessthenumber.viewmodels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableField
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
    val attemptsRemaining: LiveData<Int>
        get() = _attemptsRemaining

    private val _guessedNumber = MutableLiveData<Int>()
    val guessedNumber: LiveData<Int>
        get() = _guessedNumber

    private val _guessResult = MutableLiveData<Int>()
    val guessResult: LiveData<Int>
        get() = _guessResult

    init {
        _attemptsRemaining.value = maxAttempts
    }

    private val _guessError = MutableLiveData<String?>()
    val guessError: LiveData<String?>
        get() = _guessError
    val guessedNumberField = ObservableField<String>()

    fun makeGuess() {
        guessedNumberField.get().isNullOrEmpty().let { isEmpty: Boolean ->
            if (isEmpty) {
                _guessError.value = "Enter a number!"
                return
            } else {
                _guessError.value = ""
                guessedNumberField.get()?.toIntOrNull()?.let { guessedNumber: Int ->
                    _attemptsRemaining.value = _attemptsRemaining.value!! - 1
                    val result = guessedNumber.compareTo(number)
                    if (result == 0) {
// Won
                    } else if (_attemptsRemaining.value == 0) {
// Lost
                    }
                    _guessResult.value = result
                    _guessedNumber.value = guessedNumber
                    guessedNumberField.set("")
                }
            }
        }
    }


}