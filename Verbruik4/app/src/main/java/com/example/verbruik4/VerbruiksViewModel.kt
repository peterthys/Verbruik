package com.example.verbruik4

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class VerbruiksViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllVerbruik: LiveData<List<Verbruik>>
    private val repository : VerbruikRepository

    init {
        val verbruikDao = VerbruiksDatabase.getDatabase(application).verbruikDao()
        repository = VerbruikRepository(verbruikDao)
        readAllVerbruik = repository.readAllVerbruik
    }
}


