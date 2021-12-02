package com.example.voer

class Spel(jetonsArrayList: ArrayList<Jetons>) {
    private var jetonAdaptor: JetonAdaptor? = null
    val jeton: Jetons? = null
    val speler: String? = jeton?.speler

    var combinatiesVierHorizontaal: ArrayList<CombinatiesMetVier> = ArrayList()
    var combinatiesVierVertikaal: ArrayList<CombinatiesMetVier> = ArrayList()
    var combinatiesVierDiagonaalStijgend: ArrayList<CombinatiesMetVier> = ArrayList()
    var combinatiesVierDiagonaalDalend: ArrayList<CombinatiesMetVier> = ArrayList()
    lateinit var jetonsArrayList: ArrayList<Jetons>

    fun herstartSpel(){
        for (jeton in jetonsArrayList){
            jeton.speler="null"
            jetonAdaptor!!.notifyDataSetChanged()
        }
    }

    fun combinatiesUpdaten() {
        var cijfers1 : List<Int> = listOf(0,1,2,3,7,8,9,10,14,15,16,17,21,22,23,24,28,29,30,31,35,36,37,38)
        for (i in cijfers1) {
            if (jetonsArrayList[i].speler == jetonsArrayList[i + 1].speler &&
                jetonsArrayList[i + 1].speler == jetonsArrayList[i + 2].speler &&
                jetonsArrayList[i + 2].speler == jetonsArrayList[i + 3].speler
            ) {
                combinatiesVierHorizontaal.add(
                    CombinatiesMetVier(
                        jetonsArrayList[i],
                        jetonsArrayList[i + 1],
                        jetonsArrayList[i + 2],
                        jetonsArrayList[i + 3]
                    )
                )
            }
        }
        var cijfers2 : List<Int> = listOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
        for (i in cijfers2) {
            if (jetonsArrayList[i].speler == jetonsArrayList[i + 7].speler &&
                jetonsArrayList[i + 7].speler == jetonsArrayList[i + 14].speler &&
                jetonsArrayList[i + 14].speler == jetonsArrayList[i + 21].speler
            ) {
                combinatiesVierVertikaal.add(
                    CombinatiesMetVier(
                        jetonsArrayList[i],
                        jetonsArrayList[i + 7],
                        jetonsArrayList[i + 14],
                        jetonsArrayList[i + 21]
                    )
                )
            }
        }
        var cijfers3 : List<Int> = listOf(21,22,23,24,28,29,30,31,35,36,37,38)
        for (i in cijfers3) {
            if (jetonsArrayList[i].speler == jetonsArrayList[i -6].speler &&
                jetonsArrayList[i - 6].speler == jetonsArrayList[i - 12].speler &&
                jetonsArrayList[i - 12].speler == jetonsArrayList[i - 18].speler
            ) {
                combinatiesVierDiagonaalStijgend.add(
                    CombinatiesMetVier(
                        jetonsArrayList[i],
                        jetonsArrayList[i -6],
                        jetonsArrayList[i -12],
                        jetonsArrayList[i -18]
                    )
                )
            }
        }
        var cijfers4 : List<Int> = listOf(24,25,26,27,31,32,33,34,38,39,40,41)
        for (i in cijfers4) {
            if (jetonsArrayList[i].speler == jetonsArrayList[i -8].speler &&
                jetonsArrayList[i -8].speler == jetonsArrayList[i -16].speler &&
                jetonsArrayList[i -16].speler == jetonsArrayList[i -24].speler
            ) {
                combinatiesVierDiagonaalDalend.add(
                    CombinatiesMetVier(
                        jetonsArrayList[i],
                        jetonsArrayList[i -8],
                        jetonsArrayList[i -16],
                        jetonsArrayList[i -24]
                    )
                )
            }
        }
    }
}