package com.example.voer

class GameCalculator(
    var jetonArrayList: ArrayList<Jeton>,
    var combination4List: ArrayList<Combinations4>
) {
    private var jetonAdaptor: JetonAdaptor? = null


    fun setCorrectPlace(jeton: Jeton, position: Int, colorPlayer: String) {

        if (position in 35..41) {
            jetonArrayList!![position].player = "player"
            jetonArrayList!![position].color = colorPlayer

        } else
            if (position in 28..34) {

                if (jetonArrayList!![position + 7].player == "null") {
                    jetonArrayList!![position + 7].player = "player"
                    jetonArrayList!![position + 7].color = colorPlayer
                } else {
                    jetonArrayList!![position].player = "player"
                    jetonArrayList!![position].color = colorPlayer
                }
            } else
                if (position in 21..27) {

                    if ((jetonArrayList!![position + 14].player == "null")) {
                        jetonArrayList!![position + 14].player = "player"
                        jetonArrayList!![position + 14].color = colorPlayer
                    } else
                        if (jetonArrayList!![position + 7].player == "null") {
                            jetonArrayList!![position + 7].player = "player"
                            jetonArrayList!![position + 7].color = colorPlayer
                        } else {
                            jetonArrayList!![position].player = "player"
                            jetonArrayList!![position].color = colorPlayer
                        }

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
                                } else {
                                    jetonArrayList!![position].player = "player"
                                    jetonArrayList!![position].color = colorPlayer
                                }

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
                                        } else {
                                            jetonArrayList!![position].player = "player"
                                            jetonArrayList!![position].color = colorPlayer
                                        }

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
                                            jetonArrayList!![position + 21].player = "player"
                                            jetonArrayList!![position + 21].color =
                                                colorPlayer
                                        } else
                                            if ((jetonArrayList!![position + 14].player == "null")) {
                                                jetonArrayList!![position + 14].player = "player"
                                                jetonArrayList!![position + 14].color = colorPlayer
                                            } else
                                                if (jetonArrayList!![position + 7].player == "null") {
                                                    jetonArrayList!![position + 7].player = "player"
                                                    jetonArrayList!![position + 7].color =
                                                        colorPlayer
                                                } else {
                                                    jetonArrayList!![position].player = "player"
                                                    jetonArrayList!![position].color = colorPlayer
                                                }

                            }


//        if (jeton.player == "player") {
//            jeton.color = colorPlayer
//        }

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
                    (comb.jeton2.player == "player" || comb.jeton1.player == "computer") &&
                    (comb.jeton1.player == "null")
                ) {
                    return comb.jeton1
                } else
                    if ((comb.jeton1.player == comb.jeton2.player) &&
                        (comb.jeton2.player == comb.jeton4.player) &&
                        (comb.jeton1.player == "player" || comb.jeton1.player == "computer") &&
                        (comb.jeton3.player == "null")
                    ) {
                        return comb.jeton3
                    } else
                        if ((comb.jeton1.player == comb.jeton3.player) &&
                            (comb.jeton3.player == comb.jeton4.player) &&
                            (comb.jeton1.player == "player" || comb.jeton1.player == "computer") &&
                            (comb.jeton2.player == "null")
                        ) {
                            return comb.jeton2
                        }
        jetonArrayList[0].player = "nobody"

        return jetonArrayList[0]

    }

    fun control2OnARow(): Jeton {

        for (comb: Combinations4 in combination4List)

            if ((comb.jeton2.player == comb.jeton3.player) &&
                (comb.jeton2.player == "player" || comb.jeton2.player == "computer") &&
                ((comb.jeton1.player == "null") && (comb.jeton4.player == "null"))
            ) {
                val choice = listOf(comb.jeton1, comb.jeton4)
                var jetonComputer = choice.random()
                return jetonComputer
            } else
                if ((comb.jeton1.player == comb.jeton4.player) &&
                    (comb.jeton1.player == "player" || comb.jeton1.player == "computer") &&
                    ((comb.jeton2.player == "null") && (comb.jeton3.player == "null"))
                ) {
                    val choice = listOf(comb.jeton2, comb.jeton3)
                    var jetonComputer = choice.random()
                    return jetonComputer
                } else
                    if ((comb.jeton1.player == comb.jeton3.player) &&
                        (comb.jeton1.player == "player" || comb.jeton1.player == "computer") &&
                        ((comb.jeton2.player == "null") && (comb.jeton4.player == "null"))
                    ) {
                        val choice = listOf(comb.jeton2, comb.jeton4)
                        var jetonComputer = choice.random()
                        return jetonComputer
                    } else
                        if ((comb.jeton2.player == comb.jeton4.player) &&
                            (comb.jeton2.player == "player" || comb.jeton2.player == "computer") &&
                            ((comb.jeton1.player == "null") && (comb.jeton3.player == "null"))
                        ) {
                            val choice = listOf(comb.jeton1, comb.jeton3)
                            var jetonComputer = choice.random()
                            return jetonComputer
                        }

        jetonArrayList[0].player = "nobody"
        return jetonArrayList[0]

    }

}