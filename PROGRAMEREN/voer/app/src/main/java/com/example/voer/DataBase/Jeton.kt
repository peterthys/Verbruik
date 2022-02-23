package com.example.voer.DataBase

import android.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.voer.COMPUTER

@Entity(tableName = "jeton_table")
data class Jeton(
    @PrimaryKey
    var position: Int = 0,
    var r: Int = 0,
    var k: Int = 0,
    var color: Int = Color.WHITE,
    var player: String = ""
    )







