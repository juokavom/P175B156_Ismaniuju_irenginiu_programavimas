package edu.ktu.guessthenumber.viewmodels

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import edu.ktu.guessthenumber.R
import edu.ktu.guessthenumber.databinding.FragmentGameBinding
import java.util.*
import kotlin.random.Random

class GameViewModel(
    val minRange: Int = 1,
    val maxRange: Int = 100,
    val maxAttempts: Int = 7,
    application: Application
) : AndroidViewModel(application) {

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
                _guessError.value =
                    getApplication<Application>().resources.getString(R.string.nan_or_empty)
                return
            } else {
                _guessError.value = null
                guessedNumberField.get()?.toIntOrNull()?.let { guessedNumber: Int ->
                    _attemptsRemaining.value = _attemptsRemaining.value!! - 1
                    val result = guessedNumber.compareTo(number)
                    if (result == 0) {
                        // Won
                        _win.value = true
                    } else if (_attemptsRemaining.value == 0) {
                        // Lost
                        _lose.value = true
                    }
                    _guessResult.value = result
                    _guessedNumber.value = guessedNumber
                    guessedNumberField.set("")
                }
            }
        }
    }

    private val _win = MutableLiveData<Boolean>()
    val win: LiveData<Boolean>
        get() = _win
    private val _lose = MutableLiveData<Boolean>()
    val lose: LiveData<Boolean>
        get() = _lose

    fun navigatedToWin() {
        _win.value = false
    }

    fun navigatedToLose() {
        _lose.value = false
    }
}

class GameViewModelFactory(
    val minRange: Int = 1,
    val maxRange: Int = 100,
    val maxAttempts: Int = 7,
    val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(minRange, maxRange, maxAttempts, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}