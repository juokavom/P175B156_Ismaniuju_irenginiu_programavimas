package com.sf10.actors

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch

class ActorViewModel(context: Context) : ViewModel() {

    private val _actors = MutableLiveData<List<Actor>>()
    val actors: LiveData<List<Actor>>
        get() = _actors

    val database = Room.databaseBuilder(context, ActorDatabase::class.java, "actors").build()

    init {
        getAllActors()
    }

    fun getAllActors() {
        viewModelScope.launch {
            _actors.postValue(database.actorDao().getAll())
        }
    }

    fun addActor(fullName: String?, birthYear: String?, movie: String?) {
        if (fullName != null && birthYear != null && movie != null) {
            birthYear.toIntOrNull()?.let {
                val actor = Actor(0, fullName, it, movie)
                viewModelScope.launch {
                    database.actorDao().insertActor(actor)
                    getAllActors()
                }
            }
        }
    }

    fun filter(year: String?, movie: String?) {
        if (!year.isNullOrEmpty()) {
            getAllYounger(year)
        } else if (!movie.isNullOrEmpty()) {
            getAllFromMovie(movie)
        } else {
            getAllActors()
        }
    }

    private fun getAllYounger(year: String?) {
        year?.toIntOrNull()?.let {
            viewModelScope.launch {
                _actors.postValue(database.actorDao().getYounger(it))
            }
        }
    }

    private fun getAllFromMovie(movie: String?) {
        movie?.let {
            viewModelScope.launch {
                _actors.postValue(database.actorDao().getByMovie(movie))
            }
        }
    }

    fun deleteActor(actor: Actor) {
        viewModelScope.launch {
            database.actorDao().deleteActor(actor)
            getAllActors()
        }
    }
}