package com.example.winkellijst.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface BoodschapDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(boodschap: Boodschap)

    @Query("SELECT *FROM item_table ORDER BY id ASC")
    fun readAllItems(): LiveData<List<Boodschap>>

    @Delete
    suspend fun deleteBoodschap(boodschap: Boodschap)

    @Query("DELETE FROM item_table")
    suspend fun deleteAllBoodschap()

}