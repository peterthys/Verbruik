package com.example.voer.DataBase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JetonViewModel(application: Application):AndroidViewModel(application) {
    var jetonList : LiveData<List<Jeton>>
    //var settings: LiveData<Settings>
    private val repository : JetonRepository
    //private val repository2 : SettingsRepository

    init {
        val jetonDao= JetonDatabase.getDatabase(application).jetonDao()
        repository = JetonRepository(jetonDao)
        jetonList = repository.jetonList
    }
    fun addJeton(jeton: Jeton){
        viewModelScope.launch(Dispatchers.IO){
            repository.addJeton(jeton)
        }
    }
    fun updateJeton(jeton: Jeton){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateJeton(jeton)
        }
    }
}
