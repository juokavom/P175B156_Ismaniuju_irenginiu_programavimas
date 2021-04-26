package edu.ktu.doggyroomstarter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.ktu.doggyroomstarter.models.Dog
import edu.ktu.doggyroomstarter.utils.MockData

class DogViewModel : ViewModel() {

    private val _dogs = MutableLiveData<List<Dog>>()
    val dogs: LiveData<List<Dog>>
        get() = _dogs

    init {
        _dogs.postValue(MockData.dogs)
    }

}