package com.example.voer

import com.example.voer.DataBase.Jeton

class GameCalculator(
    var jetonArrayList: ArrayList<Jeton>,
    var combination4List: ArrayList<Combinations4>
) {


    fun setCorrectPlace(position: Int): Jeton {


        when (position) {
            in 35..41 -> {
                return jetonArrayList[position]

            }
            in 28..34 -> {

                when (jetonArrayList[position + 7].player) {
                    "" -> {
                        return jetonArrayList[position + 7]
                    }
                    else -> {
                        return jetonArrayList[position]
                    }
                }
            }
            in 21..27 -> {

                when {
                    jetonArrayList[position + 14].player == "" -> {
                        return jetonArrayList[position + 14]
                    }
                    jetonArrayList[position + 7].player == "" -> {
                        return jetonArrayList[position + 7]
                    }
                    else -> {
                        return jetonArrayList[position]
                    }
                }

            }
            in 14..20 -> {
                when {
                    jetonArrayList[position + 21].player == "" -> {
                        return jetonArrayList[position + 21]
                    }
                    jetonArrayList[position + 14].player == "" -> {
                        return jetonArrayList[position + 14]
                    }
                    jetonArrayList[position + 7].player == "" -> {
                        return jetonArrayList[position + 7]
                    }
                    else -> {
                        return jetonArrayList[position]
                    }
                }

            }
            in 7..13 -> {

                when {
                    jetonArrayList[position + 28].player == "" -> {
                        return jetonArrayList[position + 28]
                    }
                    jetonArrayList[position + 21].player == "" -> {
                        return jetonArrayList[position + 21]
                    }
                    jetonArrayList[position + 14].player == "" -> {
                        return jetonArrayList[position + 14]
                    }
                    jetonArrayList[position + 7].player == "" -> {
                        return jetonArrayList[position + 7]
                    }
                    else -> {
                        return jetonArrayList[position]
                    }
                }

            }
            in 0..6 -> {

                when {
                    jetonArrayList[position + 35].player == "" -> {
                        return jetonArrayList[position + 35]
                    }
                    jetonArrayList[position + 28].player == "" -> {
                        return jetonArrayList[position + 28]
                    }
                    jetonArrayList[position + 21].player == "" -> {
                        return jetonArrayList[position + 21]
                    }
                    jetonArrayList[position + 14].player == "" -> {
                        return jetonArrayList[position + 14]
                    }
                    jetonArrayList[position + 7].player == "" -> {
                        return jetonArrayList[position + 7]
                    }
                    else -> {
                        return jetonArrayList[position]
                    }
                }

            }
            else -> return jetonArrayList[position]
        }
    }

    fun control4OnARow(): String {

        for (comb: Combinations4 in combination4List)

            if ((comb.jeton1.player == comb.jeton2.player)
                && (comb.jeton2.player == comb.jeton3.player) &&
                (comb.jeton3.player == comb.jeton4.player) &&
                (comb.jeton1.player == "player" || comb.jeton1.player == "computer"
                        )
            ) {
                comb.jeton1.color = BLUE
                comb.jeton2.color = BLUE
                comb.jeton3.color = BLUE
                comb.jeton4.color = BLUE
                return comb.jeton1.player
            }
        return "1"
    }


    fun control3OnARow(): Jeton {
        for (comb: Combinations4 in combination4List)

            when {
                (comb.jeton1.player == comb.jeton2.player) &&
                        (comb.jeton2.player == comb.jeton3.player) &&
                        (comb.jeton1.player == COMPUTER) &&
                        (comb.jeton4.player == "") -> {
                    val jetonComputer = setCorrectPlace(comb.jeton4.position)
                    while (jetonComputer == comb.jeton4) {
                        return comb.jeton4
                    }
                }
                (comb.jeton2.player == comb.jeton3.player) &&
                        (comb.jeton3.player == comb.jeton4.player) &&
                        (comb.jeton2.player == COMPUTER) &&
                        (comb.jeton1.player == "") -> {
                    val jetonComputer = setCorrectPlace(comb.jeton1.position)
                    while (jetonComputer == comb.jeton1) {
                        return comb.jeton1
                    }
                }
                (comb.jeton1.player == comb.jeton2.player) &&
                        (comb.jeton2.player == comb.jeton4.player) &&
                        (comb.jeton1.player == COMPUTER) &&
                        (comb.jeton3.player == "") -> {
                    val jetonComputer = setCorrectPlace(comb.jeton4.position)
                    while (jetonComputer == comb.jeton4) {
                        return comb.jeton3
                    }
                }
                (comb.jeton1.player == comb.jeton3.player) &&
                        (comb.jeton3.player == comb.jeton4.player) &&
                        (comb.jeton1.player == COMPUTER) &&
                        (comb.jeton2.player == "") -> {
                    val jetonComputer = setCorrectPlace(comb.jeton2.position)
                    while (jetonComputer == comb.jeton2) {
                        return comb.jeton2
                    }
                }
            }

        for (comb: Combinations4 in combination4List)

            when {
                (comb.jeton1.player == comb.jeton2.player) &&
                        (comb.jeton2.player == comb.jeton3.player) &&
                        (comb.jeton1.player == PLAYER) &&
                        (comb.jeton4.player == "") -> {
                    val jetonComputer = setCorrectPlace(comb.jeton4.position)
                    while (jetonComputer == comb.jeton4) {
                        return comb.jeton4
                    }
                }
                (comb.jeton2.player == comb.jeton3.player) &&
                        (comb.jeton3.player == comb.jeton4.player) &&
                        (comb.jeton2.player == PLAYER) &&
                        (comb.jeton1.player == "") -> {
                    val jetonComputer = setCorrectPlace(comb.jeton1.position)
                    while (jetonComputer == comb.jeton1) {
                        return comb.jeton1
                    }
                }
                (comb.jeton1.player == comb.jeton2.player) &&
                        (comb.jeton2.player == comb.jeton4.player) &&
                        (comb.jeton1.player == PLAYER) &&
                        (comb.jeton3.player == "") -> {
                    val jetonComputer = setCorrectPlace(comb.jeton3.position)
                    while (jetonComputer == comb.jeton3) {
                        return comb.jeton3
                    }
                }
                (comb.jeton1.player == comb.jeton3.player) &&
                        (comb.jeton3.player == comb.jeton4.player) &&
                        (comb.jeton1.player == PLAYER) &&
                        (comb.jeton2.player == "") -> {
                    val jetonComputer = setCorrectPlace(comb.jeton2.position)
                    while (jetonComputer == comb.jeton2) {
                        return comb.jeton2
                    }
                }
            }
        jetonArrayList[0].player = "nobody"

        return jetonArrayList[0]

    }

    fun control2OnARow(): Jeton {

        for (comb: Combinations4 in combination4List)

            when {
                (comb.jeton2.player == comb.jeton3.player) &&
                        (comb.jeton2.player == PLAYER || comb.jeton2.player == COMPUTER) &&
                        ((comb.jeton1.player == "") && (comb.jeton4.player == "")) -> {
                    val choice = listOf(comb.jeton1, comb.jeton4)
                    val choiceComputer = choice.random()
                    val jetonComputer = setCorrectPlace(choiceComputer.position)
                    while (jetonComputer == choiceComputer) {
                        return jetonComputer
                    }
                }
                (comb.jeton1.player == comb.jeton4.player) &&
                        (comb.jeton1.player == PLAYER || comb.jeton1.player == COMPUTER) &&
                        ((comb.jeton2.player == "") && (comb.jeton3.player == "")) -> {
                    val choice = listOf(comb.jeton2, comb.jeton3)
                    val choiceComputer = choice.random()
                    val jetonComputer = setCorrectPlace(choiceComputer.position)
                    while (jetonComputer == choiceComputer) {
                        return jetonComputer
                    }
                }
                (comb.jeton1.player == comb.jeton3.player) &&
                        (comb.jeton1.player == PLAYER || comb.jeton1.player == COMPUTER) &&
                        ((comb.jeton2.player == "") && (comb.jeton4.player == "")) -> {
                    val choice = listOf(comb.jeton2, comb.jeton4)
                    val choiceComputer = choice.random()
                    val jetonComputer = setCorrectPlace(choiceComputer.position)
                    while (jetonComputer == choiceComputer) {
                        return jetonComputer
                    }
                }
                (comb.jeton2.player == comb.jeton4.player) &&
                        (comb.jeton2.player == PLAYER || comb.jeton2.player == COMPUTER) &&
                        ((comb.jeton1.player == "") && (comb.jeton3.player == "")) -> {
                    val choice = listOf(comb.jeton1, comb.jeton3)
                    val choiceComputer = choice.random()
                    val jetonComputer = setCorrectPlace(choiceComputer.position)
                    while (jetonComputer == choiceComputer) {
                        return jetonComputer
                    }
                }
            }

        jetonArrayList[0].player = "nobody"
        return jetonArrayList[0]

    }

}