package com.example.voer

class CombinatiesMetVier() {
    lateinit var jeton: Jeton
    var r = jeton.r
    var k = jeton.k
    var jeton1 = Jeton(r, k, "","")
    var jeton2 = Jeton(r, k + 1, "","")
    var jeton3 = Jeton(r, k + 2, "","")
    var jeton4 = Jeton(r, k + 3, "","")


    constructor(jeton1: Jeton, jeton2: Jeton, jeton3: Jeton, jeton4: Jeton) : this() {
        this.jeton1 = jeton1
        this.jeton2 = jeton2
        this.jeton3 = jeton3
        this.jeton4 = jeton4
    }


}