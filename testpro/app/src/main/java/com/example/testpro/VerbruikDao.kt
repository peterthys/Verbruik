package com.example.testpro

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VerbruikDao {

    @Delete
    suspend fun deleteVerbruik(verbruik: Verbruik)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVerbruik(verbruik: Verbruik)

    @Update
    suspend fun updateVerbruik(verbruik: Verbruik)

    @Query("SELECT * FROM verbruiks_table ORDER BY id DESC")
    fun readAllVerbruik(): LiveData<List<Verbruik>>


}