package edu.ktu.doggyroomstarter.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.ktu.doggyroomstarter.database.DogDatabase

class DogViewModelFactory(private val db: DogDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DogViewModel::class.java)) {
            return DogViewModel(db) as T
        }
        throw IllegalArgumentException()
    }
}