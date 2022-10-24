package com.example.winkellijst.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "item_table")
data class Boodschap (
@PrimaryKey(autoGenerate = true)
val id : Int,
val productsName : String
        ) {
}