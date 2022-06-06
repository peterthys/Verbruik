package com.example.voer.DataBase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VoerViewModel(application: Application):AndroidViewModel(application) {
    val jetonList : LiveData<List<Jeton>>
    val settings: LiveData<List<Settings>>
    private val repository : JetonRepository
    private val repository2 : SettingsRepository

    init {
        val jetonDao = VoerDatabase.getDatabase(application).jetonDao()
        val settingsDao = VoerDatabase.getDatabase(application).settingsDao()
        repository = JetonRepository(jetonDao)
        repository2 = SettingsRepository(settingsDao)
        jetonList = repository.jetonList
        settings = repository2.theSettings
    }
    fun addJeton(jeton: Jeton){
        viewModelScope.launch(Dispatchers.IO){
            repository.addJeton(jeton)
        }
    }
    fun addSettings(settings: Settings){
        viewModelScope.launch(Dispatchers.IO) {
            repository2.addSettings(settings)
        }
    }
    fun updateJeton(jeton: Jeton){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateJeton(jeton)
        }
    }
    fun updateSettings(settings: Settings){
        viewModelScope.launch(Dispatchers.IO){
            repository2.updateSettings(settings)
        }
    }
}
