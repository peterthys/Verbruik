package com.example.voer

import android.widget.ImageView

class Jeton {

    var k : Int = 0
    var r : Int = 0
    var color : String? = null
    var afbeelding : Int = 0

    constructor(k: Int, r: Int, color: String?,afbeelding:Int) {
        this.k = k
        this.r = r
        this.color = color
        this.afbeelding = afbeelding
    }
}