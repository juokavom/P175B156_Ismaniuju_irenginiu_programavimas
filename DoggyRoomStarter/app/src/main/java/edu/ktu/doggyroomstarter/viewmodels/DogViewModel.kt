package edu.ktu.doggyroomstarter.viewmodels

import androidx.lifecycle.*
import edu.ktu.doggyroomstarter.database.DogDatabase
import edu.ktu.doggyroomstarter.models.Dog
import edu.ktu.doggyroomstarter.utils.MockData
import kotlinx.coroutines.launch

class DogViewModel(private val db: DogDatabase) : ViewModel() {
    private val _dogs = db.dogDao().getAllDogs().asLiveData()
    val dogs: LiveData<List<Dog>>
        get() = _dogs

    fun addDog() {
        viewModelScope.launch {
            db.dogDao().insertAll(MockData.getRandomDog())
        }
    }

    fun deleteDog(dog: Dog) {
        viewModelScope.launch {
            db.dogDao().delete(dog)
        }
    }

}