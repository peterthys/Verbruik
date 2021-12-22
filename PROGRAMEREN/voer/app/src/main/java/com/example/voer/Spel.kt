package com.example.voer

import android.app.Application
import android.app.PendingIntent.getActivity
import android.content.Context
import android.widget.Toast

class Spel(jetonArrayList: ArrayList<Jeton>){
    private var jetonAdaptor: JetonAdaptor? = null
    var jeton: Jeton? = null
    var speler: String? = jeton?.speler

    var combinatiesVierHorizontaal: ArrayList<CombinatiesMetVier> = ArrayList()
    var combinatiesVierVertikaal: ArrayList<CombinatiesMetVier> = ArrayList()
    var combinatiesVierDiagonaalStijgend: ArrayList<CombinatiesMetVier> = ArrayList()
    var combinatiesVierDiagonaalDalend: ArrayList<CombinatiesMetVier> = ArrayList()
    var jetonArrayList: ArrayList<Jeton> = jetonArrayList
    var jetonComputer :  Jeton? = null

    fun setCorrectPlace(jeton:Jeton,position: Int,colorPlayer:String):String{
        if (position in 35..41) {
            if (jeton.speler=="null"){
            jetonArrayList!![position].speler = "speler"}
            else {
                return "Jeton is reeds bezet, maak een andere keuze !\nMaak een andere keuze."
            }

        } else
            if (position in 28..34) {
                if (jetonArrayList!![position + 7].speler == "null") {
                    jetonArrayList!![position + 7].speler = "speler"
                    jetonArrayList!![position + 7].kleur = colorPlayer
                } else
                    jetonArrayList!![position].speler = "speler"
            } else
                if (position in 21..27) {
                    if ((jetonArrayList!![position + 14].speler == "null")) {
                        jetonArrayList!![position + 14].speler = "speler"
                        jetonArrayList!![position + 14].kleur = colorPlayer
                    } else
                        if (jetonArrayList!![position + 7].speler == "null") {
                            jetonArrayList!![position + 7].speler = "speler"
                            jetonArrayList!![position + 7].kleur = colorPlayer
                        } else
                            jetonArrayList!![position].speler = "speler"
                } else
                    if (position in 14..20) {
                        if ((jetonArrayList!![position + 21].speler == "null")) {
                            jetonArrayList!![position + 21].speler = "speler"
                            jetonArrayList!![position + 21].kleur = colorPlayer
                        } else
                            if ((jetonArrayList!![position + 14].speler == "null")) {
                                jetonArrayList!![position + 14].speler = "speler"
                                jetonArrayList!![position + 14].kleur = colorPlayer
                            } else
                                if (jetonArrayList!![position + 7].speler == "null") {
                                    jetonArrayList!![position + 7].speler = "speler"
                                    jetonArrayList!![position + 7].kleur = colorPlayer
                                } else
                                    jetonArrayList!![position].speler = "speler"
                    } else
                        if (position in 7..13) {
                            if ((jetonArrayList!![position + 28].speler == "null")) {
                                jetonArrayList!![position + 28].speler = "speler"
                                jetonArrayList!![position + 28].kleur = colorPlayer
                            } else
                                if ((jetonArrayList!![position + 21].speler == "null")) {
                                    jetonArrayList!![position + 21].speler = "speler"
                                    jetonArrayList!![position + 21].kleur = colorPlayer
                                } else
                                    if ((jetonArrayList!![position + 14].speler == "null")) {
                                        jetonArrayList!![position + 14].speler = "speler"
                                        jetonArrayList!![position + 14].kleur = colorPlayer
                                    } else
                                        if (jetonArrayList!![position + 7].speler == "null") {
                                            jetonArrayList!![position + 7].speler = "speler"
                                            jetonArrayList!![position + 7].kleur = colorPlayer
                                        } else
                                            jetonArrayList!![position].speler = "speler"
                        } else
                            if (position in 0..6) {
                                if ((jetonArrayList!![position + 35].speler == "null")) {
                                    jetonArrayList!![position + 35].speler = "speler"
                                    jetonArrayList!![position + 35].kleur = colorPlayer
                                } else
                                    if ((jetonArrayList!![position + 28].speler == "null")) {
                                        jetonArrayList!![position + 28].speler = "speler"
                                        jetonArrayList!![position + 28].kleur = colorPlayer
                                    } else
                                        if ((jetonArrayList!![position + 21].speler == "null")) {
                                            jetonArrayList!![position + 21].speler = "speler"
                                            jetonArrayList!![position + 21].kleur = colorPlayer
                                        } else
                                            if ((jetonArrayList!![position + 14].speler == "null")) {
                                                jetonArrayList!![position + 14].speler = "speler"
                                                jetonArrayList!![position + 14].kleur =
                                                    colorPlayer
                                            } else
                                                if (jetonArrayList!![position + 7].speler == "null") {
                                                    jetonArrayList!![position + 7].speler = "speler"
                                                    jetonArrayList!![position + 7].kleur =
                                                        colorPlayer
                                                } else
                                                    jetonArrayList!![position].speler = "speler"

                            }
        if (jeton.speler == "speler") {
            jeton.kleur = colorPlayer
        }
return "speler"
    }
    fun controle4Horizontaal(): String {

        val cijfers1: List<Int> = listOf(
            0, 1, 2, 3, 7, 8, 9, 10, 14, 15, 16, 17, 21, 22, 23, 24, 28, 29, 30, 31, 35, 36, 37, 38
        )

        for (i in cijfers1)
            if (jetonArrayList!![i].speler == jetonArrayList!![i + 1].speler &&
            jetonArrayList!![i + 1].speler == jetonArrayList!![i + 2].speler &&
            jetonArrayList!![i + 2].speler == jetonArrayList!![i + 3].speler &&
            (jetonArrayList!![i].speler == "speler" || jetonArrayList!![i].speler == "computer")
        ) {
            return "${jetonArrayList!![i].speler}"

        }
        return "1"
    }
    fun controle3Horizontaal(): Jeton? {

        val cijfers5: List<Int> = listOf(

            1,
            2,
            3,
            4,
            7,
            8,
            9,
            10,
            11,
            14,
            15,
            16,
            17,
            18,
            21,
            22,
            23,
            24,
            25,
            28,
            29,
            30,
            31,
            32,
            35,
            36,
            37,
            38
        )

        val cijfers5b: List<Int> =
            listOf (-1, 6, 13, 20, 27, 34, 5, 12, 19, 26, 33, 40, 7, 14, 21, 28, 35, 43)

        for (i in cijfers5)
            if (jetonArrayList!![i].speler == jetonArrayList!![i + 1].speler &&
                jetonArrayList!![i + 1].speler == jetonArrayList!![i + 2].speler &&
                (jetonArrayList!![i - 1].speler == "null") &&
                !(cijfers5b.contains(i - 1))
            ) {
                jetonComputer = jetonArrayList!![i - 1]
            } else
                if (jetonArrayList!![i].speler == jetonArrayList!![i + 1].speler &&
                    jetonArrayList!![i + 1].speler == jetonArrayList!![i + 2].speler &&
                    jetonArrayList!![i + 3].speler == "null" &&
                    !(cijfers5b.contains(i + 3))
                ) {
                    jetonComputer = jetonArrayList!![i + 3]
                }
                else
                     {
                         controle2Horizontaal()
                    }
        return jetonComputer
    }

    fun controle2Horizontaal(){

    }
    fun controleVoerVerti(jeton:Jeton): String {

        val cijfers1: List<Int> = listOf(
            0,
            1,
            2,
            3,
            7,
            8,
            9,
            10,
            14,
            15,
            16,
            17,
            21,
            22,
            23,
            24,
            28,
            29,
            30,
            31,
            35,
            36,
            37,
            38
        )

//        for (i in cijfers1) if (jetonArrayList[i].speler == jetonArrayList[i + 1].speler &&
//            jetonArrayList[i + 1].speler == jetonArrayList[i + 2].speler &&
//            jetonArrayList[i + 2].speler == jetonArrayList[i + 3].speler
//        ) {
//            return "1 "
//
//        }
            return "HOERA"
    }

//    fun combinatiesUpdaten() {
//
//        var cijfers1 : List<Int> = listOf(0,1,2,3,7,8,9,10,14,15,16,17,21,22,23,24,28,29,30,31,35,36,37,38)
//        for (i in cijfers1) {
//            if (jetonArrayList[i].speler == jetonArrayList[i + 1].speler &&
//                jetonArrayList[i + 1].speler == jetonArrayList[i + 2].speler &&
//                jetonArrayList[i + 2].speler == jetonArrayList[i + 3].speler
//            ) {
//
//                combinatiesVierHorizontaal.add(
//                    CombinatiesMetVier(
//                        jetonArrayList[i],
//                        jetonArrayList[i + 1],
//                        jetonArrayList[i + 2],
//                        jetonArrayList[i + 3]
//                    )
//                )
//            }else
//
//        }
//
//        var cijfers2 : List<Int> = listOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
//        for (i in cijfers2) {
//            if (jetonArrayList[i].speler == jetonArrayList[i + 7].speler &&
//                jetonArrayList[i + 7].speler == jetonArrayList[i + 14].speler &&
//                jetonArrayList[i + 14].speler == jetonArrayList[i + 21].speler
//            ) {
//
//                combinatiesVierVertikaal.add(
//                    CombinatiesMetVier(
//                        jetonArrayList[i],
//                        jetonArrayList[i + 7],
//                        jetonArrayList[i + 14],
//                        jetonArrayList[i + 21]
//                    )
//                )
//            }
//        }
//        var cijfers3 : List<Int> = listOf(21,22,23,24,28,29,30,31,35,36,37,38)
//        for (i in cijfers3) {
//            if (jetonArrayList[i].speler == jetonArrayList[i -6].speler &&
//                jetonArrayList[i - 6].speler == jetonArrayList[i - 12].speler &&
//                jetonArrayList[i - 12].speler == jetonArrayList[i - 18].speler
//            ) {
//                combinatiesVierDiagonaalStijgend.add(
//                    CombinatiesMetVier(
//                        jetonArrayList[i],
//                        jetonArrayList[i -6],
//                        jetonArrayList[i -12],
//                        jetonArrayList[i -18]
//                    )
//                )
//            }
//        }
//        var cijfers4 : List<Int> = listOf(24,25,26,27,31,32,33,34,38,39,40,41)
//        for (i in cijfers4) {
//            if (jetonArrayList[i].speler == jetonArrayList[i -8].speler &&
//                jetonArrayList[i -8].speler == jetonArrayList[i -16].speler &&
//                jetonArrayList[i -16].speler == jetonArrayList[i -24].speler
//            ) {
//                combinatiesVierDiagonaalDalend.add(
//                    CombinatiesMetVier(
//                        jetonArrayList[i],
//                        jetonArrayList[i -8],
//                        jetonArrayList[i -16],
//                        jetonArrayList[i -24]
//                    )
//                )
//            }
//        }
//
//    }

//        var combinatieHorizontaal : CombinatiesMetVier= CombinatiesMetVier(jeton,jeton2,jeton3,jeton4)
//   //     if (jeton in combinatieHorizontaal
//        for (combinatiesVierHorizontaal.contains(combinatieHorizontaal)){
//
//            if (combinatieHorizontaal.contains()){
//
//
//        }
//
//    }

        fun controleVoer(jeton: Jeton) {
            val rij = jeton.r
            val kolom = jeton.k
            val kleur = jeton.kleur
            val speler = jeton.speler

        }

     }