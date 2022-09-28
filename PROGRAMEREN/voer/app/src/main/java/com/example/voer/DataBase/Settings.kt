package com.example.voer.DataBase

import android.graphics.Color
import android.graphics.Color.WHITE
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings_table")
data class Settings(

    var whoseTurn: String = "",
    var colorPlayer: Int = Color.WHITE,
    var colorComputer: Int = Color.WHITE,
    @PrimaryKey
    val id : Int = 1
)