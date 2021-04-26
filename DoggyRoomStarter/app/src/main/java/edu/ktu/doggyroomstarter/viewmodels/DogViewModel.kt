package edu.ktu.doggyroomstarter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ktu.doggyroomstarter.database.DogDatabase
import edu.ktu.doggyroomstarter.models.Dog
import edu.ktu.doggyroomstarter.utils.MockData
import kotlinx.coroutines.launch

class DogViewModel(private val db: DogDatabase) : ViewModel() {
    private val _dogs = MutableLiveData<List<Dog>>()
    val dogs: LiveData<List<Dog>>
        get() = _dogs

    init {
        getDogs()
    }

    fun addDog() {
        viewModelScope.launch {
            db.dogDao().insertAll(MockData.getRandomDog())
            getDogs()
        }
    }

    private fun getDogs() {
        viewModelScope.launch {
            _dogs.postValue(db.dogDao().getAllDogs())
        }
    }

    fun deleteDog(dog: Dog) {
        viewModelScope.launch {
            db.dogDao().delete(dog)
            getDogs()
        }
    }

}