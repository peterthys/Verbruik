package com.example.voer

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.jeton_ontwerp.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var gridView: GridView? = null
    private var jetonArrayList: ArrayList<Jetons>? = null
    private var jetonAdaptor: JetonAdaptor? = null
    private var spel: Spel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val red: Int = Color.parseColor("#F53241")
        jeton?.setColorFilter(Color.RED)
        textView.setTextColor(red)
        gridView = findViewById(R.id.grid_view)
        val button: Button = findViewById(R.id.herstart_button)
        button.setOnClickListener {
            for (jeton in jetonArrayList!!) {
                jeton.speler = "null"
                jetonAdaptor!!.notifyDataSetChanged()
            }


        }
        val kleurGeel: Button = findViewById(R.id.radioButton_geel)

        jetonArrayList = ArrayList()
        jetonArrayList = setJetonsList()
        jetonAdaptor = JetonAdaptor(applicationContext, jetonArrayList!!)
        gridView?.adapter = jetonAdaptor
        gridView?.onItemClickListener = this

    }


    private fun setJetonsList(): ArrayList<Jetons> {

        for (r: Int in 6 downTo 1) {
            for (k: Int in 1..7) {
                jetonArrayList!!.add(Jetons(r, k, "null"))
            }
        }
        return jetonArrayList!!

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var jeton: Jetons = jetonArrayList!!.get(position)
        if (position in 35..41) {
            jetonArrayList!![position].speler = "speler"
        }

        if (position in 28..34) {
            if (jetonArrayList!![position + 7].speler == "null") {
                jetonArrayList!![position + 7].speler = "speler"
            } else
                jetonArrayList!![position].speler = "speler"
        }
        if (position in 21..27) {
            if ((jetonArrayList!![position + 7].speler == "null") && (jetonArrayList!![position + 14].speler == "null")) {
                jetonArrayList!![position + 14].speler = "speler"
            } else
                if (jetonArrayList!![position + 7].speler == "null") {
                    jetonArrayList!![position + 7].speler = "speler"
                } else
                    jetonArrayList!![position].speler = "speler"
        }
        if (position in 14..20) {
            if ((jetonArrayList!![position + 7].speler == "null") &&
                (jetonArrayList!![position + 14].speler == "null") &&
                (jetonArrayList!![position + 21].speler == "null")
            ) {

                jetonArrayList!![position + 21].speler = "speler"
            } else
                if ((jetonArrayList!![position + 7].speler == "null") && (jetonArrayList!![position + 14].speler == "null")) {
                    jetonArrayList!![position + 14].speler = "speler"
                } else
                    if (jetonArrayList!![position + 7].speler == "null") {
                        jetonArrayList!![position + 7].speler = "speler"
                    } else
                        jetonArrayList!![position].speler = "speler"
        }
        if (position in 7..13) {
            if ((jetonArrayList!![position + 7].speler == "null") &&
                (jetonArrayList!![position + 14].speler == "null") &&
                (jetonArrayList!![position + 21].speler == "null") &&
                (jetonArrayList!![position + 28].speler == "null")
            ) {

                jetonArrayList!![position + 28].speler = "speler"
            } else
                if ((jetonArrayList!![position + 7].speler == "null") &&
                    (jetonArrayList!![position + 14].speler == "null") &&
                    (jetonArrayList!![position + 21].speler == "null")
                ) {

                    jetonArrayList!![position + 21].speler = "speler"
                } else
                    if ((jetonArrayList!![position + 7].speler == "null") && (jetonArrayList!![position + 14].speler == "null")) {
                        jetonArrayList!![position + 14].speler = "speler"
                    } else
                        if (jetonArrayList!![position + 7].speler == "null") {
                            jetonArrayList!![position + 7].speler = "speler"
                        } else
                            jetonArrayList!![position].speler = "speler"
        }
        if (position in 0..6) {
            if ((jetonArrayList!![position + 7].speler == "null") &&
                (jetonArrayList!![position + 14].speler == "null") &&
                (jetonArrayList!![position + 21].speler == "null") &&
                (jetonArrayList!![position + 28].speler == "null") &&
                (jetonArrayList!![position + 35].speler == "null")
            ) {

                jetonArrayList!![position + 35].speler = "speler"
            } else
                if ((jetonArrayList!![position + 7].speler == "null") &&
                    (jetonArrayList!![position + 14].speler == "null") &&
                    (jetonArrayList!![position + 21].speler == "null")
                ) {

                    jetonArrayList!![position + 21].speler = "speler"
                } else
                    if ((jetonArrayList!![position + 7].speler == "null") && (jetonArrayList!![position + 14].speler == "null")) {
                        jetonArrayList!![position + 14].speler = "speler"
                    } else
                        if (jetonArrayList!![position + 7].speler == "null") {
                            jetonArrayList!![position + 7].speler = "speler"
                        } else
                            jetonArrayList!![position].speler = "speler"
        }

        jetonAdaptor!!.notifyDataSetChanged()

        Toast.makeText(applicationContext, "${jeton.speler}", Toast.LENGTH_LONG).show()

    }
}