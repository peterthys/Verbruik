package com.example.voer.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jeton_table")
data class Jeton(
    @PrimaryKey
    var position: Int = 0,
    var r: Int = 0,
    var k: Int = 0,
    var color: String = "white",
    var player: String? = "null",


)







