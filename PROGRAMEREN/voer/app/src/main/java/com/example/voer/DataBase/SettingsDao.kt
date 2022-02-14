package com.example.voer.DataBase

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface SettingsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSettings(settings:Settings)

    @Query("SELECT * FROM settings_table")
    fun readSettings(): LiveData<Settings>

    @Update
    suspend fun updateSettings(settings:Settings)


}
