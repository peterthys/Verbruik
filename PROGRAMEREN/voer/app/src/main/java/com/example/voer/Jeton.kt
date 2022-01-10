package com.example.voer

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jeton_table")
data class Jeton(
    @PrimaryKey(autoGenerate = true)

    var r: Int = 0,
    var k: Int = 0,
    var color: String = "white",
    var player: String? = "null",
    var position: Int = 0,
    val id: Int
)







