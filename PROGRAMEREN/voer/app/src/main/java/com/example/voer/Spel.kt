package com.example.voer

import android.view.View
import android.widget.AdapterView
import android.widget.RadioButton

class Spel(jetonArrayList: ArrayList<Jetons>) {
    private var jetonAdaptor: JetonAdaptor? = null
    val jeton: Jetons? = null
    val speler: String? = jeton?.speler

    var combinatiesVierHorizontaal: ArrayList<CombinatiesMetVier> = ArrayList()
    var combinatiesVierVertikaal: ArrayList<CombinatiesMetVier> = ArrayList()
    var combinatiesVierDiagonaalStijgend: ArrayList<CombinatiesMetVier> = ArrayList()
    var combinatiesVierDiagonaalDalend: ArrayList<CombinatiesMetVier> = ArrayList()
    lateinit var jetonArrayList: ArrayList<Jetons>








    fun combinatiesUpdaten() {
        var cijfers1 : List<Int> = listOf(0,1,2,3,7,8,9,10,14,15,16,17,21,22,23,24,28,29,30,31,35,36,37,38)
        for (i in cijfers1) {
            if (jetonArrayList[i].speler == jetonArrayList[i + 1].speler &&
                jetonArrayList[i + 1].speler == jetonArrayList[i + 2].speler &&
                jetonArrayList[i + 2].speler == jetonArrayList[i + 3].speler
            ) {
                combinatiesVierHorizontaal.add(
                    CombinatiesMetVier(
                        jetonArrayList[i],
                        jetonArrayList[i + 1],
                        jetonArrayList[i + 2],
                        jetonArrayList[i + 3]
                    )
                )
            }
        }
        var cijfers2 : List<Int> = listOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
        for (i in cijfers2) {
            if (jetonArrayList[i].speler == jetonArrayList[i + 7].speler &&
                jetonArrayList[i + 7].speler == jetonArrayList[i + 14].speler &&
                jetonArrayList[i + 14].speler == jetonArrayList[i + 21].speler
            ) {
                combinatiesVierVertikaal.add(
                    CombinatiesMetVier(
                        jetonArrayList[i],
                        jetonArrayList[i + 7],
                        jetonArrayList[i + 14],
                        jetonArrayList[i + 21]
                    )
                )
            }
        }
        var cijfers3 : List<Int> = listOf(21,22,23,24,28,29,30,31,35,36,37,38)
        for (i in cijfers3) {
            if (jetonArrayList[i].speler == jetonArrayList[i -6].speler &&
                jetonArrayList[i - 6].speler == jetonArrayList[i - 12].speler &&
                jetonArrayList[i - 12].speler == jetonArrayList[i - 18].speler
            ) {
                combinatiesVierDiagonaalStijgend.add(
                    CombinatiesMetVier(
                        jetonArrayList[i],
                        jetonArrayList[i -6],
                        jetonArrayList[i -12],
                        jetonArrayList[i -18]
                    )
                )
            }
        }
        var cijfers4 : List<Int> = listOf(24,25,26,27,31,32,33,34,38,39,40,41)
        for (i in cijfers4) {
            if (jetonArrayList[i].speler == jetonArrayList[i -8].speler &&
                jetonArrayList[i -8].speler == jetonArrayList[i -16].speler &&
                jetonArrayList[i -16].speler == jetonArrayList[i -24].speler
            ) {
                combinatiesVierDiagonaalDalend.add(
                    CombinatiesMetVier(
                        jetonArrayList[i],
                        jetonArrayList[i -8],
                        jetonArrayList[i -16],
                        jetonArrayList[i -24]
                    )
                )
            }
        }
    }
}