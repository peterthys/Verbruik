package com.example.voer.DataBase

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface SettingsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSettings(settings:Settings)

    @Query("SELECT * FROM settings_table WHERE id = 1")
    fun readSettings(): LiveData<List<Settings>>

    @Update
    suspend fun updateSettings(settings:Settings)


}
