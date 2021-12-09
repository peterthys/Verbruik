package com.example.voer

import android.content.Intent

class CombinatiesMetVier() {
    lateinit var jeton: Jetons
    var r = jeton.r
    var k = jeton.k
    var jeton1 = Jetons(r, k, "")
    var jeton2 = Jetons(r, k + 1, "")
    var jeton3 = Jetons(r, k + 2, "")
    var jeton4 = Jetons(r, k + 3, "")


    constructor(jeton1: Jetons, jeton2: Jetons, jeton3: Jetons, jeton4: Jetons) : this() {
        this.jeton1 = jeton1
        this.jeton2 = jeton2
        this.jeton3 = jeton3
        this.jeton4 = jeton4
    }


}