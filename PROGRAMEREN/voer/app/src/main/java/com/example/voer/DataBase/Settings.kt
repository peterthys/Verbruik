package com.example.voer.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings_table")
data class Settings(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var whoseTurn: String = "",
    var colorPlayer: Int = 0,
    var colorCoputer: Int = 0
)
