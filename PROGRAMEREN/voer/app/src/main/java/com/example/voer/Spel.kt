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
            } else
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
                } else
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


        if (jeton.player == "player") {
            jeton.color = colorPlayer
        }
        return "player"
    }


    fun control4OnARow(): String {

        for (comb: Combinations4 in combination4List)

            if ((comb.jeton1.player == comb.jeton2.player)
                && (comb.jeton2.player == comb.jeton3.player) &&
                (comb.jeton3.player == comb.jeton4.player) &&
                (comb.jeton1.player == "player" || comb.jeton1.player == "computer"
                        )
            ) {
                comb.jeton1.color = "blue"
                comb.jeton2.color = "blue"
                comb.jeton3.color = "blue"
                comb.jeton4.color = "blue"
                return comb.jeton1.player!!
            }
        return "1"
    }


    fun control3OnARow(): Jeton {
        for (comb: Combinations4 in combination4List)

            if ((comb.jeton1.player == comb.jeton2.player) &&
                (comb.jeton2.player == comb.jeton3.player) &&
                (comb.jeton1.player == "player" || comb.jeton1.player == "computer") &&
                (comb.jeton4.player == "null")
            ) {
                return comb.jeton4
            } else
                if ((comb.jeton2.player == comb.jeton3.player) &&
                    (comb.jeton3.player == comb.jeton4.player) &&
                    (comb.jeton2.player == "player" || comb.jeton1.player == "computer")
                ) {
                    return comb.jeton1
                } else
                    if ((comb.jeton1.player == comb.jeton2.player) &&
                        (comb.jeton2.player == comb.jeton4.player) &&
                        (comb.jeton1.player == "player" || comb.jeton1.player == "computer")
                    ) {
                        return comb.jeton3
                    } else
                        if ((comb.jeton1.player == comb.jeton3.player) &&
                            (comb.jeton3.player == comb.jeton4.player) &&
                            (comb.jeton1.player == "player" || comb.jeton1.player == "computer")
                        ) {
                            return comb.jeton2
                        }

        return jetonArrayList[0]

    }

    fun control2OnARow(): Jeton {

        for (comb: Combinations4 in combination4List)

            if ((comb.jeton2.player == comb.jeton3.player) &&
                (comb.jeton2.player == "player" || comb.jeton2.player == "computer") &&
                ((comb.jeton1.player == "null") && (comb.jeton4.player == "null"))
            ) {
                val choice = listOf<Jeton>(comb.jeton1 , comb.jeton4)
                var jetonComputer = choice.random()
                return jetonComputer
            } else
                if ((comb.jeton1.player == comb.jeton4.player) &&
                    (comb.jeton1.player == "player" || comb.jeton1.player == "computer") &&
                    ((comb.jeton2.player == "null") && (comb.jeton3.player == "null"))
                ) {
                    val choice = listOf<Jeton>(comb.jeton2 , comb.jeton3)
                    var jetonComputer = choice.random()
                    return jetonComputer
                } else
                    if ((comb.jeton1.player == comb.jeton3.player) &&
                        (comb.jeton1.player == "player" || comb.jeton1.player == "computer") &&
                        ((comb.jeton2.player == "null") && (comb.jeton4.player == "null"))
                    ) {
                        val choice = listOf<Jeton>(comb.jeton2 , comb.jeton4)
                        var jetonComputer = choice.random()
                        return jetonComputer
                    } else
                        if ((comb.jeton2.player == comb.jeton4.player) &&
                            (comb.jeton2.player == "player" || comb.jeton2.player == "computer") &&
                            ((comb.jeton1.player == "null") && (comb.jeton3.player == "null"))
                        ) {
                            val choice = listOf<Jeton>(comb.jeton1 , comb.jeton3)
                            var jetonComputer = choice.random()
                            return jetonComputer}


            return jetonArrayList[0]

    }



}