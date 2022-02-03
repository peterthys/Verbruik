package com.example.voer.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Jeton::class/*, Settings::class*/], version = 3, exportSchema = false)
abstract class JetonDatabase : RoomDatabase() {

    abstract fun jetonDao(): JetonDao
    //abstract fun jetonDao(): SettingsDao

    companion object {
        @Volatile
        private var INSTANCE: JetonDatabase? = null
        fun getDatabase(context: Context): JetonDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JetonDatabase::class.java,
                    "jeton_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}