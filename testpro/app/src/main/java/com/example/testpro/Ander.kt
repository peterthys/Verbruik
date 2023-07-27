package com.example.testpro

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize // nodig om data over te brengen
data class Ander(
    val name: String,
    var glazen: Int,
    var cl25: Int,
    var cl33: Int,
    var aantal: Int,
    val caloriePerHonderdMl: Int
) : Parcelable // nodig om data over te brengen