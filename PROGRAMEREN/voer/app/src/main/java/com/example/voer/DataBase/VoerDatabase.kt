package com.example.voer.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Jeton::class, Settings::class], version = 8, exportSchema = false)
abstract class VoerDatabase : RoomDatabase() {

    abstract fun jetonDao(): JetonDao
    abstract fun settingsDao(): SettingsDao

    companion object {
        @Volatile
        private var INSTANCE: VoerDatabase? = null
        fun getDatabase(context: Context): VoerDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VoerDatabase::class.java,
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