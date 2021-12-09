package com.example.voer

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var gridView: GridView? = null
    private var jetonArrayList: ArrayList<Jetons>? = null
    private var jetonAdaptor: JetonAdaptor? = null
    private var spel: Spel? = null
    var choosenColor: String = "null"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gridView = findViewById(R.id.grid_view)
        val buttonHerstart: Button = findViewById(R.id.herstart_button)
        val ButtonGeel: Button = findViewById(R.id.radioButton_geel)
        val ButtonRood: Button = findViewById(R.id.radioButton_rood)
        buttonHerstart.setOnClickListener {
            for (jeton in jetonArrayList!!) {
                jeton.speler = "null"
                ButtonGeel.setVisibility(View.VISIBLE)
                ButtonRood.setVisibility(View.VISIBLE)
                jeton.kleur = "null"
                jetonAdaptor!!.notifyDataSetChanged()
            }

        }

        ButtonGeel.setOnClickListener {
            choosenColor = "geel"
            ButtonGeel.setVisibility(View.GONE)
            ButtonRood.setVisibility(View.GONE)
        }


        ButtonRood.setOnClickListener {
            choosenColor = "rood"
            ButtonGeel.setVisibility(View.GONE)
            ButtonRood.setVisibility(View.GONE)
        }


        jetonArrayList = ArrayList()
        jetonArrayList = setJetonsList()
        jetonAdaptor = JetonAdaptor(applicationContext, jetonArrayList!!)
        gridView?.adapter = jetonAdaptor
        gridView?.onItemClickListener = this


    }


    private fun setJetonsList(): ArrayList<Jetons> {

        for (r: Int in 6 downTo 1) {
            for (k: Int in 1..7) {
                jetonArrayList!!.add(Jetons(r, k, "null", "null"))
            }
        }
        return jetonArrayList!!

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var jeton: Jetons = jetonArrayList!!.get(position)

        if (position in 35..41) {
            jetonArrayList!![position].speler = "speler"
        }
else
        if (position in 28..34) {
            if (jetonArrayList!![position + 7].speler == "null") {
                jetonArrayList!![position + 7].speler = "speler"
                jetonArrayList!![position+7].kleur = choosenColor
            } else
                jetonArrayList!![position].speler = "speler"
        }
        else
        if (position in 21..27) {
            if ((jetonArrayList!![position + 7].speler == "null") && (jetonArrayList!![position + 14].speler == "null")) {
                jetonArrayList!![position + 14].speler = "speler"
                jetonArrayList!![position+14].kleur = choosenColor
            } else
                if (jetonArrayList!![position + 7].speler == "null") {
                    jetonArrayList!![position + 7].speler = "speler"
                    jetonArrayList!![position+7].kleur = choosenColor
                } else
                    jetonArrayList!![position].speler = "speler"
        }
        else
        if (position in 14..20) {
            if ((jetonArrayList!![position + 7].speler == "null") &&
                (jetonArrayList!![position + 14].speler == "null") &&
                (jetonArrayList!![position + 21].speler == "null")
            ) {

                jetonArrayList!![position + 21].speler = "speler"
                jetonArrayList!![position+21].kleur = choosenColor
            } else
                if ((jetonArrayList!![position + 7].speler == "null") && (jetonArrayList!![position + 14].speler == "null")) {
                    jetonArrayList!![position + 14].speler = "speler"
                    jetonArrayList!![position+14].kleur = choosenColor
                } else
                    if (jetonArrayList!![position + 7].speler == "null") {
                        jetonArrayList!![position + 7].speler = "speler"
                        jetonArrayList!![position+7].kleur = choosenColor
                    } else
                        jetonArrayList!![position].speler = "speler"
        }
        else
        if (position in 7..13) {
            if ((jetonArrayList!![position + 7].speler == "null") &&
                (jetonArrayList!![position + 14].speler == "null") &&
                (jetonArrayList!![position + 21].speler == "null") &&
                (jetonArrayList!![position + 28].speler == "null")
            ) {

                jetonArrayList!![position + 28].speler = "speler"
                jetonArrayList!![position+28].kleur = choosenColor
            } else
                if ((jetonArrayList!![position + 7].speler == "null") &&
                    (jetonArrayList!![position + 14].speler == "null") &&
                    (jetonArrayList!![position + 21].speler == "null")
                ) {

                    jetonArrayList!![position + 21].speler = "speler"
                    jetonArrayList!![position+21].kleur = choosenColor
                } else
                    if ((jetonArrayList!![position + 7].speler == "null") && (jetonArrayList!![position + 14].speler == "null")) {
                        jetonArrayList!![position + 14].speler = "speler"
                        jetonArrayList!![position+14].kleur = choosenColor
                    } else
                        if (jetonArrayList!![position + 7].speler == "null") {
                            jetonArrayList!![position + 7].speler = "speler"
                            jetonArrayList!![position+7].kleur = choosenColor
                        } else
                            jetonArrayList!![position].speler = "speler"
        }
        else
        if (position in 0..6) {
            if ((jetonArrayList!![position + 7].speler == "null") &&
                (jetonArrayList!![position + 14].speler == "null") &&
                (jetonArrayList!![position + 21].speler == "null") &&
                (jetonArrayList!![position + 28].speler == "null") &&
                (jetonArrayList!![position + 35].speler == "null")
            ) {
                jetonArrayList!![position + 35].speler = "speler"
                jetonArrayList!![position+35].kleur = choosenColor
            } else
                if ((jetonArrayList!![position + 7].speler == "null") &&
                    (jetonArrayList!![position + 14].speler == "null") &&
                    (jetonArrayList!![position + 21].speler == "null") &&
                    (jetonArrayList!![position + 28].speler == "null")

                    ) {
                jetonArrayList!![position + 28].speler = "speler"
                jetonArrayList!![position+28].kleur = choosenColor
            } else
                if ((jetonArrayList!![position + 7].speler == "null") &&
                    (jetonArrayList!![position + 14].speler == "null") &&
                    (jetonArrayList!![position + 21].speler == "null")
                ) {
                    jetonArrayList!![position + 21].speler = "speler"
                    jetonArrayList!![position+21].kleur = choosenColor
                } else
                    if ((jetonArrayList!![position + 7].speler == "null") && (jetonArrayList!![position + 14].speler == "null")) {
                        jetonArrayList!![position + 14].speler = "speler"
                        jetonArrayList!![position+14].kleur = choosenColor
                    } else
                        if (jetonArrayList!![position + 7].speler == "null") {
                            jetonArrayList!![position + 7].speler = "speler"
                            jetonArrayList!![position+7].kleur = choosenColor
                        } else
                            jetonArrayList!![position].speler = "speler"
        }
        if (jeton.speler == "speler") {
            jeton.kleur = choosenColor
        }
        jetonAdaptor!!.notifyDataSetChanged()

        Toast.makeText(applicationContext, "${jeton.speler}", Toast.LENGTH_LONG).show()

    }
}