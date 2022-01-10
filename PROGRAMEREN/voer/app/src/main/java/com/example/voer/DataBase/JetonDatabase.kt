package com.example.voer.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.voer.Jeton

@Database(entities = [Jeton::class], version = 1, exportSchema = false)
abstract class JetonDatabase : RoomDatabase() {

    abstract fun jetonDao(): JetonDao

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
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}