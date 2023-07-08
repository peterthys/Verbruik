package com.example.testpro

import androidx.lifecycle.LiveData

class VerbruikRepository (private val verbruikDao: VerbruikDao){
    val readAllVerbruik : LiveData<List<Verbruik>> = verbruikDao.readAllVerbruik()
    suspend fun addVerbruik (verbruik: Verbruik){
        verbruikDao.addVerbruik(verbruik)}

    suspend fun updateVerbruik (verbruik: Verbruik){
        verbruikDao.updateVerbruik(verbruik)

    }
    suspend fun deleteVerbruik (verbruik: Verbruik){
        verbruikDao.deleteVerbruik(verbruik)
    }

}