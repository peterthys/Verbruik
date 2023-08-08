package com.example.testpro

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "verbruiks_table")
data class Verbruik(
    val datum: String,
    val pils: Int = 0,
    val duvel: Int = 0,
    val wijn: Int = 0,
    val westmalle : Int = 0,
    val kwak : Int = 0,
    val anderAantal: Int = 0,
    val anderNaam: String ="",
    val anderInhoud: Int = 0,
    val anderCalorie: Int = 0,
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
): Parcelable // nodig om argumenten van het ene fragment naar het andere te brengen
