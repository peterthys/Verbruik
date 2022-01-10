package com.example.voer.DataBase

import androidx.lifecycle.LiveData
import com.example.voer.Jeton

class JetonRepository(private val jetonDao: JetonDao) {
    val jetonArrayList: LiveData<List<Jeton>> = jetonDao.readAllData()
    suspend fun addJeton(jeton: Jeton) {
        jetonDao.addJeton(jeton)
    }
    suspend fun updateJeton(jeton: Jeton){
        jetonDao.updateJeton(jeton)
    }
}

