package com.example.verbruik4

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "verbruiks_table")
data class Verbruik(
    val datum: Long = 0L,
    val pils: Int = 0,
    val duvel: Int = 0,
    val wijn: Int = 0,
    val westmalle : Int = 0,
    val kwak : Int = 0,
    val ander: Int = 0,
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)
