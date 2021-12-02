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
    private var spel : Spel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView: ImageView? = findViewById(R.id.imageView_valies)
        val red: Int = Color.parseColor("#F53241")
        imageView?.setColorFilter(red)
        jeton?.setColorFilter(Color.RED)
        textView.setTextColor(red)
        gridView = findViewById(R.id.grid_view)
        val button: Button = findViewById(R.id.herstart_button)
        button.setOnClickListener {
            spel?.herstartSpel()
            jetonAdaptor!!.notifyDataSetChanged()
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


                jetonArrayList!!.add(Jetons(r, k, "0"))

            }
        }
        var i = 0
        for (r: Int in 6 downTo 1) {


            for (k: Int in 1..7) {


                var jeton: Jetons = jetonArrayList!![i]
                var kolom = jeton.k
                var rij = jeton.r
                if ((rij % kolom) == 0) {
                    jeton.speler = "speler"
                } else if ((rij % kolom) > 1) {
                    jeton.speler = "comp"
                } else {
                    jeton.speler = "0"
                }

                i++
            }
        }
        return jetonArrayList!!


    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var jeton: Jetons = jetonArrayList!!.get(position)
        jeton.speler = "speler"
        jetonArrayList!![position].speler = "speler"
        // jetonAdaptor!!.getView(position, View(this), GridView)
//        val cirkels: ImageView = view!!.findViewById(R.id.jeton)
//        cirkels.setImageResource(R.drawable.black_cirkel)
        //       jetonArrayList!!.remove(jeton)
//        jetonArrayList
        //       setJetonsList()
        jetonAdaptor!!.notifyDataSetChanged()
        var tekstr = jetonArrayList!![0].r.toString()
        var tekstk = jetonArrayList!![0].k.toString()
        Toast.makeText(applicationContext, "${jeton.speler}", Toast.LENGTH_LONG).show()
        //Toast.makeText(applicationContext,"r=$tekstr"+"k=$tekstk",Toast.LENGTH_LONG).show()
    }
}