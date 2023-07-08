package com.example.verbruik4

import androidx.lifecycle.LiveData

class VerbruikRepository (private val verbruikDao: VerbruikDao){
    val readAllVerbruik : LiveData<List<Verbruik>> = verbruikDao.readAllVerbruik()
    suspend fun addVerbruik (verbruik: Verbruik){
        verbruikDao.addVerbruik(verbruik)
    }
}