package com.example.winkellijst.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Boodschap::class], version = 2, exportSchema = false)
abstract class BoodschapDatabase : RoomDatabase() {
    abstract fun itemDao(): BoodschapDao
    companion object{
        @Volatile
        private var INSTANCE: BoodschapDatabase? = null

        fun getDatabase(context: Context):BoodschapDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BoodschapDatabase::class.java,
                    "boodschap_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}