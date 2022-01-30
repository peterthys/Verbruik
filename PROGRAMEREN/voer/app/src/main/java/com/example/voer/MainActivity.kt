@file:Suppress("ControlFlowWithEmptyBody")

package com.example.voer

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.voer.DataBase.JetonViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var gridView: GridView
    private var jetonArrayList: ArrayList<Jeton> = ArrayList()
    private var combination4List: ArrayList<Combinations4>? = ArrayList()
    private lateinit var jetonAdaptor: JetonAdaptor
    private lateinit var gameCalculator: GameCalculator
    private var colorPlayer: String = "null"
    private var colorComputer: String = "null"
    private var aanZet: String = "computer"
    private lateinit var mJetonViewModel : JetonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mJetonViewModel = ViewModelProvider(this).get(JetonViewModel::class.java)
        gridView = findViewById(R.id.grid_view)
        jetonArrayList = setJetonsList()
        combination4List = setCombinatieList()
        jetonAdaptor = JetonAdaptor(applicationContext, jetonArrayList)
        gridView.adapter = jetonAdaptor
        gridView.onItemClickListener = this
        gameCalculator = GameCalculator(jetonArrayList, combination4List!!)

        startSpel()

    }

    private fun setJetonsList(): ArrayList<Jeton> {

        for (r: Int in 6 downTo 1) {
            var position = 0
            for (k: Int in 1..7) {
                jetonArrayList.add(Jeton(r, k, "null", "null", position,0))
                insertJetonToDatabase(Jeton(r, k, "null", "null", position,0))
                position++
            }
        }
        return jetonArrayList
    }

    private fun setCombinatieList(): ArrayList<Combinations4> {
        val cijfers1: List<Int> = listOf(
            0, 1, 2, 3, 7, 8, 9, 10, 14, 15, 16, 17, 21, 22, 23, 24, 28, 29, 30, 31, 35, 36, 37, 38
        )
        val cijfers2: List<Int> = listOf(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
        )
        val cijfers3: List<Int> = listOf(
            3, 4, 5, 6, 10, 11, 12, 13, 17, 18, 19, 20
        )
        val cijfers4: List<Int> = listOf(
            0, 1, 2, 3, 7, 8, 9, 10, 14, 15, 16, 17
        )
        //Vier horizontaal
        for (i in cijfers1) {
            val comb4 = Combinations4(
                jetonArrayList[i],
                jetonArrayList[i + 1],
                jetonArrayList[i + 2],
                jetonArrayList[i + 3]
            )
            combination4List!!.add(comb4)
        }
        //Vier vertikaal
        for (i in cijfers2) {
            val comb4 = Combinations4(
                jetonArrayList[i],
                jetonArrayList[i + 7],
                jetonArrayList[i + 14],
                jetonArrayList[i + 21]
            )
            combination4List!!.add(comb4)
        }
        //Vier diagonaal stijgend
        for (i in cijfers3) {
            val comb4 = Combinations4(
                jetonArrayList[i],
                jetonArrayList[i + 6],
                jetonArrayList[i + 12],
                jetonArrayList[i + 18]
            )
            combination4List!!.add(comb4)
        }
        //Vier diagonaal dalend
        for (i in cijfers4) {
            val comb4 = Combinations4(
                jetonArrayList[i],
                jetonArrayList[i + 8],
                jetonArrayList[i + 16],
                jetonArrayList[i + 24]
            )
            combination4List!!.add(comb4)
        }
        return combination4List!!
    }


    fun startSpel() {

        val buttonHerstart: Button = findViewById(R.id.herstart_button)
        val ButtonGeel: Button = findViewById(R.id.radioButton_geel)
        val ButtonRood: Button = findViewById(R.id.radioButton_rood)
        val ButtonIkBegin: Button = findViewById(R.id.button_ik_begin)
        val ButtonComputerBegint: Button = findViewById(R.id.button_computer_begint)
        ButtonIkBegin.setVisibility(View.GONE)
        ButtonComputerBegint.setVisibility(View.GONE)
        textView.setTextColor(Color.BLACK)
        textView.setText("Welkom bij Vier op een rij !\nKies de kleur waarmee je wil spelen.")


        ButtonGeel.setOnClickListener {
            colorPlayer = "yellow"
            colorComputer = "red"
            ButtonGeel.setVisibility(View.GONE)
            ButtonRood.setVisibility(View.GONE)
            ButtonIkBegin.setVisibility(View.VISIBLE)
            ButtonComputerBegint.setVisibility(View.VISIBLE)
            textView.setText("Kies wie begint.")
        }
        ButtonRood.setOnClickListener {
            colorPlayer = "red"
            colorComputer = "yellow"
            ButtonGeel.setVisibility(View.GONE)
            ButtonRood.setVisibility(View.GONE)
            ButtonIkBegin.setVisibility(View.VISIBLE)
            ButtonComputerBegint.setVisibility(View.VISIBLE)
            textView.setText("Kies wie begint.")

        }

        ButtonIkBegin.setOnClickListener {
            textView.setText("\nPlaats je jeton")
            ButtonGeel.setVisibility(View.GONE)
            ButtonRood.setVisibility(View.GONE)
            ButtonIkBegin.setVisibility(View.GONE)
            ButtonComputerBegint.setVisibility(View.GONE)
            aanZet = "speler"
        }
        ButtonComputerBegint.setOnClickListener {
            ButtonGeel.setVisibility(View.GONE)
            ButtonRood.setVisibility(View.GONE)
            ButtonIkBegin.setVisibility(View.GONE)
            ButtonComputerBegint.setVisibility(View.GONE)
            firstJetonComputer()
        }
        buttonHerstart.setOnClickListener {
            for (jeton in jetonArrayList!!) {
                jeton.player = "null"
                jeton.color = "null"
                ButtonGeel.setVisibility(View.VISIBLE)
                ButtonRood.setVisibility(View.VISIBLE)
                ButtonIkBegin.setVisibility(View.GONE)
                ButtonComputerBegint.setVisibility(View.GONE)
                insertJetonToDatabase(jeton)
                jetonAdaptor.notifyDataSetChanged()
            }
            aanZet = "computer"
        }

    }


    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val jeton: Jeton = jetonArrayList.get(position)
        if (aanZet == "computer") {
            Toast.makeText(applicationContext, "Je bent niet aan zet !", Toast.LENGTH_LONG).show()
        } else
            controlAllreadyChoosen(jeton, position)
        val voer: String = gameCalculator.control4OnARow()
        if (voer == "player") {
            textView.setTextColor(Color.RED)
            textView.setText("\n\n Jij hebt gewonnen!\n Proficiat")
            aanZet = "nobody"
        }
        nextJetonComputer()

        aanZet = "player"

        val voer2 = gameCalculator.control4OnARow()

        if (voer2 == "computer") {
            textView.setTextColor(Color.RED)
            textView.setText("\n\n Computer heeft gewonnen!")
            aanZet = "computer"
        }
    }

    fun controlAllreadyChoosen(jeton: Jeton, position: Int) {

        if (jeton.color == "red" || jeton.color == "yellow") {
            Toast.makeText(
                applicationContext,
                "Jeton is reeds bezet !\nMaak een andere keuze.",
                Toast.LENGTH_SHORT
            ).show()

        } else {
            val jetonPlayer = gameCalculator.setCorrectPlace(position)
            jetonPlayer.color = colorPlayer
            jetonPlayer.player = "player"
            updateJetonToDatabase(jetonPlayer)
            jetonAdaptor.notifyDataSetChanged()
            aanZet="computer"
        }

    }

    fun firstJetonComputer(): Jeton {
        val randomGetal: Int = (3..5).random()
        val firstJeton = jetonArrayList[34 + randomGetal]
        firstJeton.color = colorComputer
        firstJeton.player = "computer"
        textView.setText("\n\njouw beurt")
        aanZet = "player"
        updateJetonToDatabase(firstJeton)
        jetonAdaptor.notifyDataSetChanged()
        return firstJeton

    }

    private fun nextJetonComputer() {
        if (aanZet == "computer") {
            val freeJetonsList: ArrayList<Jeton> = ArrayList()
            var jetonComputer = gameCalculator.control3OnARow()
            if (jetonComputer.player == "null") {
                jetonComputer.player = "computer"
                jetonComputer.color = colorComputer
                jetonArrayList[0].player = "null"
                aanZet = "player"
                updateJetonToDatabase(jetonComputer)
                jetonAdaptor.notifyDataSetChanged()

            } else {
                jetonComputer = gameCalculator.control2OnARow()
                if (jetonComputer.player == "null") {
                    jetonComputer.player = "computer"
                    jetonComputer.color = colorComputer
                    jetonArrayList[0].player = "null"
                    aanZet = "player"
                    updateJetonToDatabase(jetonComputer)
                    jetonAdaptor.notifyDataSetChanged()
                } else {

                for (jeton in jetonArrayList) {
                    if (jeton.color != "red" && jeton.color != "yellow") {
                        freeJetonsList.add(jeton)
                    }
                }
                val choosenJeton = (freeJetonsList).random()
                jetonComputer = gameCalculator.setCorrectPlace(choosenJeton.position)
                jetonComputer.player = "computer"
                jetonComputer.color = colorComputer
                updateJetonToDatabase(jetonComputer)
                jetonAdaptor.notifyDataSetChanged()
                freeJetonsList.removeAll(freeJetonsList)
            }

            }
        } else {
        }
    }

    private fun insertJetonToDatabase(jeton: Jeton){
        val r = jeton.r
        val k = jeton.k
        val color = jeton.color
        val player = jeton.player
        val position = jeton.position

        val jetonForDB = Jeton(r,k,color,player,position,0)
        mJetonViewModel.addJeton(jetonForDB)

    }
    private fun updateJetonToDatabase(jeton: Jeton){
        val r = jeton.r
        val k = jeton.k
        val color = jeton.color
        val player = jeton.player
        val position = jeton.position

        val jetonToUpdate : Jeton = Jeton(r,k,color,player,position,0)
        mJetonViewModel.updateJeton(jetonToUpdate)
    }
}
