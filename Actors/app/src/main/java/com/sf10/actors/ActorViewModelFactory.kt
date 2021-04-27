package com.sf10.actors

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ActorViewModelFactory(val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ActorViewModel::class.java)) {
            return ActorViewModel(context) as T
        }
        throw IllegalArgumentException()
    }
}