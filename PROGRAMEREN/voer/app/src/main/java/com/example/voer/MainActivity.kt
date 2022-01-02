package com.example.voer

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var gridView: GridView? = null
    private var jetonArrayList: ArrayList<Jeton>? = null
    private var combination4List: ArrayList<Combinations4>? = null
    private var jetonAdaptor: JetonAdaptor? = null
    var spel: Spel? = null
    var colorPlayer: String = "null"
    var colorComputer: String = "null"
    var aanZet: String = "computer"
    //  var wrongChoice = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gridView = findViewById(R.id.grid_view)
        jetonArrayList = ArrayList()
        jetonArrayList = setJetonsList()
        combination4List = ArrayList()
        combination4List = setCombinatieList()
        jetonAdaptor = JetonAdaptor(applicationContext, jetonArrayList!!)
        gridView?.adapter = jetonAdaptor
        gridView?.onItemClickListener = this
        spel = Spel(jetonArrayList!!, combination4List!!)

        startSpel()

    }

    private fun setJetonsList(): ArrayList<Jeton> {

        for (r: Int in 6 downTo 1) {
            for (k: Int in 1..7) {
                jetonArrayList!!.add(Jeton(r, k, "null", "null"))
            }
        }
        return jetonArrayList!!
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
                jetonArrayList!![i],
                jetonArrayList!![i + 1],
                jetonArrayList!![i + 2],
                jetonArrayList!![i + 3]
            )
            combination4List!!.add(comb4)
        }
        //Vier vertikaal
        for (i in cijfers2) {
            val comb4 = Combinations4(
                jetonArrayList!![i],
                jetonArrayList!![i + 7],
                jetonArrayList!![i + 14],
                jetonArrayList!![i + 21]
            )
            combination4List!!.add(comb4)
        }
        //Vier diagonaal stijgend
        for (i in cijfers3) {
            val comb4 = Combinations4(
                jetonArrayList!![i],
                jetonArrayList!![i + 6],
                jetonArrayList!![i + 12],
                jetonArrayList!![i + 18]
            )
            combination4List!!.add(comb4)
        }
        //Vier diagonaal dalend
        for (i in cijfers4) {
            val comb4 = Combinations4(
                jetonArrayList!![i],
                jetonArrayList!![i + 8],
                jetonArrayList!![i + 16],
                jetonArrayList!![i + 24]
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
            textView.setText("\nPlaats je jeton\n Veel succes !")
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
            eersteZetJetonComputer()
        }
        buttonHerstart.setOnClickListener {
            for (jeton in jetonArrayList!!) {
                jeton.player = "null"
                jeton.color = "null"
                ButtonGeel.setVisibility(View.VISIBLE)
                ButtonRood.setVisibility(View.VISIBLE)
                ButtonIkBegin.setVisibility(View.GONE)
                ButtonComputerBegint.setVisibility(View.GONE)
                colorPlayer = "null"
                colorComputer = "null"
                aanZet = "computer"
                startSpel()
                jetonAdaptor!!.notifyDataSetChanged()
            }
        }

    }


    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val jeton: Jeton = jetonArrayList!!.get(position)
        if (aanZet == "computer") {
            Toast.makeText(applicationContext, "Je bent niet aan zet !", Toast.LENGTH_LONG).show()
        } else {
            controlAllreadyChoosen(jeton, position)

        }
        var x = spel?.control4OnARow()

        if (x == "player") {
            textView.setTextColor(Color.RED)
            textView.setText("\n\n Jij hebt gewonnen!\n Proficiat")
            aanZet = "computer"
        } else
            if (x == "computer") {
                textView.setTextColor(Color.RED)
                textView.setText("\n\n Computer heeft gewonnen!")
                aanZet = "computer"

            } else
                Toast.makeText(applicationContext, "$x", Toast.LENGTH_SHORT).show()

        nextJetonComputer()

    }

    fun controlAllreadyChoosen(jeton: Jeton, position: Int) {

        if (jeton.color == "red" || jeton.color == "yellow") {
            Toast.makeText(
                applicationContext,
                "Jeton is reeds bezet !\nMaak een andere keuze.",
                Toast.LENGTH_SHORT
            ).show()

        } else
            Toast.makeText(
                applicationContext,
                "kiekeboe !",
                Toast.LENGTH_SHORT
            ).show()
        spel?.setCorrectPlace(jeton, position, colorPlayer)

        aanZet = "computer"

        jetonAdaptor!!.notifyDataSetChanged()

    }

//    fun waitForCorrectChoice(r: Boolean) {
//        if (r == true) {
//            wrongChoice = false
//            startSpel()
//        } else
//            wrongChoice = false
//        volgendeZetComputer()
//        Toast.makeText(applicationContext, "opnieuw thuis", Toast.LENGTH_LONG).show()
//    }

    fun eersteZetJetonComputer() {
        val randomGetal: Int = (3..5).random()
        for (jeton: Jeton in jetonArrayList!!) {
            if (jeton.r == 1 && jeton.k == randomGetal) {
                jeton.color = colorComputer
                jeton.player = "computer"
            }
        }
        textView.setText("\n\njouw beurt")
        aanZet = "player"
        jetonAdaptor!!.notifyDataSetChanged()
    }

    fun setJetonPlayer() {}

    fun nextJetonComputer() {
        val jetonComputer = spel?.control3OnARow()
        if (jetonComputer != jetonArrayList!![0]) {
            jetonComputer?.player = "computer"
            jetonComputer?.color = colorComputer
            aanZet = "player"
            jetonAdaptor!!.notifyDataSetChanged()
        } else {
            Toast.makeText(applicationContext, "Hoi", Toast.LENGTH_LONG).show()
            spel?.control2OnARow()

        }


    }
}