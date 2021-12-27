package com.example.voer

class Spel(jetonArrayList: ArrayList<Jeton>, var combination4List: ArrayList<Combinations4>) {
    private var jetonAdaptor: JetonAdaptor? = null
    var jeton: Jeton? = null
    var player: String? = jeton?.player

    var combinatiesVierVertikaal: ArrayList<Combinations4> = ArrayList()
    var combinatiesVierDiagonaalStijgend: ArrayList<Combinations4> = ArrayList()
    var combinatiesVierDiagonaalDalend: ArrayList<Combinations4> = ArrayList()
    var jetonArrayList: ArrayList<Jeton> = jetonArrayList
    var jetonComputer: Jeton? = null

    fun setCorrectPlace(jeton: Jeton, position: Int, colorPlayer: String): String {

        if (position in 35..41) {
            if (jeton.player !== "null") {
                return "Jeton is reeds bezet !\nMaak een andere keuze."
            } else {
                if (jeton.player == "null") {
                    jetonArrayList!![position].player = "player"
                } else {
                    return "Jeton is reeds bezet, maak een andere keuze !\nMaak een andere keuze."
                }
            }
        } else
            if (position in 28..34) {

                if (jetonArrayList!![position + 7].player == "null") {
                    jetonArrayList!![position + 7].player = "player"
                    jetonArrayList!![position + 7].color = colorPlayer
                } else
                    jetonArrayList!![position].player = "player"
            }

             else
                if (position in 21..27) {

                        if ((jetonArrayList!![position + 14].player == "null")) {
                            jetonArrayList!![position + 14].player = "player"
                            jetonArrayList!![position + 14].color = colorPlayer
                        } else
                            if (jetonArrayList!![position + 7].player == "null") {
                                jetonArrayList!![position + 7].player = "player"
                                jetonArrayList!![position + 7].color = colorPlayer
                            } else
                                jetonArrayList!![position].player = "player"
                    }
                else
                    if (position in 14..20) {
                            if ((jetonArrayList!![position + 21].player == "null")) {
                                jetonArrayList!![position + 21].player = "player"
                                jetonArrayList!![position + 21].color = colorPlayer
                            } else
                                if ((jetonArrayList!![position + 14].player == "null")) {
                                    jetonArrayList!![position + 14].player = "player"
                                    jetonArrayList!![position + 14].color = colorPlayer
                                } else
                                    if (jetonArrayList!![position + 7].player == "null") {
                                        jetonArrayList!![position + 7].player = "player"
                                        jetonArrayList!![position + 7].color = colorPlayer
                                    } else
                                        jetonArrayList!![position].player = "player"

                    } else
                        if (position in 7..13) {

                                if ((jetonArrayList!![position + 28].player == "null")) {
                                    jetonArrayList!![position + 28].player = "player"
                                    jetonArrayList!![position + 28].color = colorPlayer
                                } else
                                    if ((jetonArrayList!![position + 21].player == "null")) {
                                        jetonArrayList!![position + 21].player = "player"
                                        jetonArrayList!![position + 21].color = colorPlayer
                                    } else
                                        if ((jetonArrayList!![position + 14].player == "null")) {
                                            jetonArrayList!![position + 14].player = "player"
                                            jetonArrayList!![position + 14].color = colorPlayer
                                        } else
                                            if (jetonArrayList!![position + 7].player == "null") {
                                                jetonArrayList!![position + 7].player = "player"
                                                jetonArrayList!![position + 7].color =
                                                    colorPlayer
                                            } else
                                                jetonArrayList!![position].player = "player"

                        } else
                            if (position in 0..6) {

                                    if ((jetonArrayList!![position + 35].player == "null")) {
                                        jetonArrayList!![position + 35].player = "player"
                                        jetonArrayList!![position + 35].color = colorPlayer
                                    } else
                                        if ((jetonArrayList!![position + 28].player == "null")) {
                                            jetonArrayList!![position + 28].player = "player"
                                            jetonArrayList!![position + 28].color = colorPlayer
                                        } else
                                            if ((jetonArrayList!![position + 21].player == "null")) {
                                                jetonArrayList!![position + 21].player =
                                                    "player"
                                                jetonArrayList!![position + 21].color =
                                                    colorPlayer
                                            } else
                                                if ((jetonArrayList!![position + 14].player == "null")) {
                                                    jetonArrayList!![position + 14].player =
                                                        "player"
                                                    jetonArrayList!![position + 14].color =
                                                        colorPlayer
                                                } else
                                                    if (jetonArrayList!![position + 7].player == "null") {
                                                        jetonArrayList!![position + 7].player =
                                                            "player"
                                                        jetonArrayList!![position + 7].color =
                                                            colorPlayer
                                                    } else
                                                        jetonArrayList!![position].player =
                                                            "player"

                                }


    if (jeton.player == "player")
    {
        jeton.color = colorPlayer
    }
    return "player"
}

fun controle4Horizontaal(): String {

    val cijfers1: List<Int> = listOf(
        0, 1, 2, 3, 7, 8, 9, 10, 14, 15, 16, 17, 21, 22, 23, 24, 28, 29, 30, 31, 35, 36, 37, 38
    )

    for (i in cijfers1)
        if (jetonArrayList!![i].player == jetonArrayList!![i + 1].player &&
            jetonArrayList!![i + 1].player == jetonArrayList!![i + 2].player &&
            jetonArrayList!![i + 2].player == jetonArrayList!![i + 3].player &&
            (jetonArrayList!![i].player == "speler" || jetonArrayList!![i].player == "computer")
        ) {
            return "${jetonArrayList!![i].player}"

        }
    return "1"
}
    fun controle4Horizontaal2(): String {
        var p = ""

//        val cijfers1: List<Int> = listOf(
//            0, 1, 2, 3, 7, 8, 9, 10, 14, 15, 16, 17, 21, 22, 23, 24, 28, 29, 30, 31, 35, 36, 37, 38
//        )
//        for (i in cijfers1)
    for (comb : Combinations4 in combination4List){

        if (comb.jeton1.player==comb.jeton2.player
            &&comb.jeton2.player==comb.jeton3.player&&
            comb.jeton3.player==comb.jeton4.player)
            {
             p = "${comb.jeton1.player}"

        }
        return p
    }

 //}

//     if (jeton in comb{
//     comb = Combinations4(jeton1:Jeton,jeton2:Jeton,jeton3:Jeton,jeton4:Jeton)
// }
//
// }
//        for (jeton in comb){
//            if (jetonArrayList!![i].player == jetonArrayList!![i + 1].player &&
//                jetonArrayList!![i + 1].player == jetonArrayList!![i + 2].player &&
//                jetonArrayList!![i + 2].player == jetonArrayList!![i + 3].player &&
//                (jetonArrayList!![i].player == "speler" || jetonArrayList!![i].player == "computer")
//            ) {
//                return "${jetonArrayList!![i].player}"
//
//            }
        return p
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
        listOf(-1, 6, 13, 20, 27, 34, 5, 12, 19, 26, 33, 40, 7, 14, 21, 28, 35, 43)

    for (i in cijfers5)
        if (jetonArrayList!![i].player == jetonArrayList!![i + 1].player &&
            jetonArrayList!![i + 1].player == jetonArrayList!![i + 2].player &&
            (jetonArrayList!![i - 1].player == "null") &&
            !(cijfers5b.contains(i - 1))
        ) {
            jetonComputer = jetonArrayList!![i - 1]
        } else
            if (jetonArrayList!![i].player == jetonArrayList!![i + 1].player &&
                jetonArrayList!![i + 1].player == jetonArrayList!![i + 2].player &&
                jetonArrayList!![i + 3].player == "null" &&
                !(cijfers5b.contains(i + 3))
            ) {
                jetonComputer = jetonArrayList!![i + 3]
            } else {
                controle2Horizontaal()
            }
    return jetonComputer
}

fun controle2Horizontaal(): Jeton {
    val cijfers1: List<Int> = listOf(
        1, 2, 3, 4, 8, 9, 10, 11, 15, 16, 17, 18, 22, 23, 24, 25, 29, 30, 31, 32, 36, 37, 38, 39
    )

    for (i in cijfers1)
        if (jetonArrayList!![i].player == jetonArrayList!![i + 1].player &&
            (jetonArrayList!![i].player == "speler" || jetonArrayList!![i].player == "computer")&&
            ((jetonArrayList!![i-1].player == "null")&&(jetonArrayList!![i+2].player == "null"))
        ) {val listJeton2 = listOf(jetonArrayList!![i-1],jetonArrayList!![i+2])
            val randomJeton: Jeton = (listJeton2).random()
            jetonComputer=randomJeton
        } else{}
            return jetonComputer!!
}

fun controleVoerVerti(): String {

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
    val kleur = jeton.color
    val speler = jeton.player

}

}