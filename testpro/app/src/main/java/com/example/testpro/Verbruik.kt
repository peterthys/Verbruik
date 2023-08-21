package com.example.testpro

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "verbruiks_table")
data class Verbruik(
    val datum: String,
    var pils: Int = 0,
    var duvel: Int = 0,
    var wijn: Int = 0,
    var westmalle: Int = 0,
    var kwak: Int = 0,
    var anderAantal: Int = 0,
    var anderNaam: String ="",
    var anderInhoud: Double = 0.0,
    var anderCalorie: Int = 0,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
): Parcelable // nodig om argumenten van het ene fragment naar het andere te brengen
