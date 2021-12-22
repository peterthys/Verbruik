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
    private var jetonAdaptor: JetonAdaptor? = null
    var spel: Spel? = null
    var colorPlayer: String = "null"
    var colorComputer: String = "null"
    var aanZet: String = "computer"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gridView = findViewById(R.id.grid_view)

        startSpel()

        jetonArrayList = ArrayList()
        jetonArrayList = setJetonsList()
        jetonAdaptor = JetonAdaptor(applicationContext, jetonArrayList!!)
        gridView?.adapter = jetonAdaptor
        gridView?.onItemClickListener = this

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
            textView.setText("\n\n\nPlaats je eerste jeton\n Veel succes !")
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
            textView.setText(
                "\n" +
                        "\n" +
                        "\nGoed, ik begin !"
            )
            eersteZetJetonComputer()
            jetonAdaptor!!.notifyDataSetChanged()
        }
        buttonHerstart.setOnClickListener {
            for (jeton in jetonArrayList!!) {
                jeton.speler = "null"
                jeton.kleur = "null"
                ButtonGeel.setVisibility(View.VISIBLE)
                ButtonRood.setVisibility(View.VISIBLE)
                ButtonIkBegin.setVisibility(View.GONE)
                ButtonComputerBegint.setVisibility(View.GONE)
                startSpel()
                jetonAdaptor!!.notifyDataSetChanged()
            }
        }

    }

    private fun setJetonsList(): ArrayList<Jeton> {

        for (r: Int in 6 downTo 1) {
            for (k: Int in 1..7) {
                jetonArrayList!!.add(Jeton(r, k, "null", "null"))
            }
        }
        return jetonArrayList!!
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val jeton: Jeton = jetonArrayList!!.get(position)
        if (aanZet == "computer") {
            Toast.makeText(applicationContext, "Je bent niet aan zet !", Toast.LENGTH_LONG).show()
        } else {
            spel = Spel(jetonArrayList!!)
            val q: String = spel!!.setCorrectPlace(jeton, position, colorPlayer)
            if (q !== "speler" && q !== "computer") {
                Toast.makeText(applicationContext, q, Toast.LENGTH_LONG).show()
            }
        }

        //   aanZet = "computer"
        jetonAdaptor!!.notifyDataSetChanged()
        var x = spel!!.controle4Horizontaal()

        if (x == "speler") {
            textView.setTextColor(Color.RED)
            textView.setText("\n\n Jij hebt gewonnen!\n Proficiat")
            aanZet = "computer"
            Toast.makeText(applicationContext, "$x", Toast.LENGTH_LONG).show()
        } else
            if (x == "computer") {
                textView.setTextColor(Color.RED)
                textView.setText("\n\n Comuter heeft gewonnen!")
                aanZet = "computer"
                Toast.makeText(applicationContext, "$x", Toast.LENGTH_LONG).show()

            } else
                Toast.makeText(applicationContext, "$x", Toast.LENGTH_LONG).show()

        volgendeZetComputer()

    }

    fun eersteZetJetonComputer() {
        val randomGetal: Int = (3..5).random()
        for (jeton: Jeton in jetonArrayList!!) {
            if (jeton.r == 1 && jeton.k == randomGetal) {
                jeton.kleur = colorComputer
                jeton.speler = "computer"
            }
        }
        textView.setText("\n\njouw beurt")
        aanZet = "speler"
        jetonAdaptor!!.notifyDataSetChanged()
    }

    fun setJetonPlayer() {}

    fun volgendeZetComputer() {
        val jetonComputer = spel?.controle3Horizontaal()
        if (jetonComputer == jetonArrayList!![0]){
Toast.makeText(applicationContext,"Hoi",Toast.LENGTH_LONG).show()
            spel?.controle2Horizontaal()
        }
        else
            jetonComputer?.speler = "computer"
        jetonComputer?.kleur = colorComputer
        jetonAdaptor!!.notifyDataSetChanged()

    }


//    fun controleDoerHorizontaal(): Jeton {
//        val cijfers5: List<Int> = listOf(
//            0,
//            1,
//            2,
//            3,
//            4,
//            7,
//            8,
//            9,
//            10,
//            11,
//            14,
//            15,
//            16,
//            17,
//            18,
//            21,
//            22,
//            23,
//            24,
//            25,
//            28,
//            29,
//            30,
//            31,
//            32,
//            35,
//            36,
//            37,
//            38,
//            39
//        )
//
//        return jetonArrayList!![0]
//    }
}