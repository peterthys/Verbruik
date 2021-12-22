package com.example.voer

class CombinatiesMetDrie {
    lateinit var jeton: Jeton
    var r = jeton.r
    var k = jeton.k
    var jeton1 = Jeton(r, k, "","")
    var jeton2 = Jeton(r, k + 1, "","")
    var jeton3 = Jeton(r, k + 2, "","")



    constructor(jeton1: Jeton, jeton2: Jeton, jeton3: Jeton) {
        this.jeton1 = jeton1
        this.jeton2 = jeton2
        this.jeton3 = jeton3

    }


}