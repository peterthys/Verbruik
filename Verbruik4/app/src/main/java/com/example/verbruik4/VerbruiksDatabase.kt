package com.example.verbruik4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomOpenHelper

@Database(
    entities = [Verbruik::class],
    version = 3
)
abstract class VerbruiksDatabase() : RoomDatabase() {

    abstract fun verbruikDao(): VerbruikDao

    companion object{

    @Volatile
    private var INSTANCE: VerbruiksDatabase? = null

    fun getDatabase(context: Context): VerbruiksDatabase{
        val tempInstance = INSTANCE
        if (tempInstance != null){
            return tempInstance
        }
        synchronized(this){
            val instance = Room.databaseBuilder(
                context.applicationContext,
                VerbruiksDatabase::class.java,
                "verbruik_database"
            ).build()
            INSTANCE = instance
            return instance
        }

    }
}}