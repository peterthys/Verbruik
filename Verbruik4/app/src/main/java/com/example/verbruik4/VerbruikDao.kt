package com.example.verbruik4

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface VerbruikDao {
//    @Upsert
//    fun insertVerbruik(verbruik: Verbruik)

    @Delete
    suspend fun deleteVerbruik(verbruik: Verbruik)

 //   @Query("SELECT * FROM verbruik ORDER BY datum ASC")
   // fun getVerbruikOrderedByDate(): Flow<List<Verbruik>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVerbruik(verbruik: Verbruik)

    @Query("SELECT * FROM verbruiks_table ORDER BY datum ASC")
     fun readAllVerbruik(): LiveData<List<Verbruik>>
}