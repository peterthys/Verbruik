package com.example.voer.DataBase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.voer.Jeton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JetonViewModel(application: Application):AndroidViewModel(application) {
    private val jetonArrayList : LiveData<List<Jeton>>
    private val repository : JetonRepository
    init {
        val jetonDao= JetonDatabase.getDatabase(application).jetonDao()
        repository = JetonRepository(jetonDao)
        jetonArrayList = repository.jetonArrayList
    }
    fun addJeton(jeton: Jeton){
        viewModelScope.launch(Dispatchers.IO){
            repository.addJeton(jeton)
        }
    }
    fun updateJeton(jeton: Jeton){
        viewModelScope.launch(Dispatchers.IO){
            repository.addJeton(jeton)
        }
    }
}