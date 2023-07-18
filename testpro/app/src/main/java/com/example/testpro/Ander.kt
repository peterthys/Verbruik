package com.example.testpro

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize // nodig om data over te brengen
data class Ander(
    val name: String,
    val aantalGlazen: Int,
    val aantal25: Int,
    val aantal33: Int,
    val caloriePerHonderdMl: Int
): Parcelable // nodig om data over te brengen