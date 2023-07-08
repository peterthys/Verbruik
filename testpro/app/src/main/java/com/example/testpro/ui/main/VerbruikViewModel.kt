package com.example.testpro.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testpro.Verbruik
import com.example.testpro.VerbruikRepository
import com.example.testpro.VerbruiksDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VerbruiksViewModel(application: Application) : AndroidViewModel(application) {

    val readAllVerbruik: LiveData<List<Verbruik>>
    private val repository: VerbruikRepository

    init {
        val verbruikDao = VerbruiksDatabase.getDatabase(application).verbruikDao()
        repository = VerbruikRepository(verbruikDao)
        readAllVerbruik = repository.readAllVerbruik
    }

    fun addVerbruik(verbruik: Verbruik) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addVerbruik(verbruik)
        }
    }
    fun updateVerbruik(verbruik: Verbruik) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateVerbruik(verbruik)
        }
    }

    fun deleteVerbruik(verbruik: Verbruik) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteVerbruik(verbruik)
        }
    }
}
