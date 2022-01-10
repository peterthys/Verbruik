package com.example.voer.DataBase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.voer.Jeton

@Dao
interface JetonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addJeton(jeton: Jeton)

    @Query("SELECT * FROM jeton_table")
    fun readAllData(): LiveData<List<Jeton>>

    @Update
    suspend fun updateJeton(jeton: Jeton)
}
