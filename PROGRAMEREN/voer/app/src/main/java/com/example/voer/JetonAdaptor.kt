package com.example.voer

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class JetonAdaptor(var context: Context, var JetonArrayList: ArrayList<Jeton>) : BaseAdapter() {

var kleurSpeler : String = "null"

    override fun getCount(): Int {
        return JetonArrayList.size
    }


    override fun getItem(position: Int): Any {
        return JetonArrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


        val view: View = View.inflate(context, R.layout.jeton_ontwerp, null)

        val cirkels: ImageView = view.findViewById(R.id.jeton)
        val tekst: TextView = view.findViewById(R.id.tv_jeton)

        val jeton: Jeton = JetonArrayList.get(position)
        cirkels.setImageResource(R.drawable.black_cirkel)

        val rij: Int = jeton.r
        val kolom: Int = jeton.k
        val kleur: String = jeton.color

        if (jeton.color == "red") {
            cirkels.setColorFilter(Color.RED)
        } else if (jeton.color == "yellow") {
            cirkels.setColorFilter(Color.YELLOW)
        } else
            cirkels.setColorFilter(Color.WHITE)

        cirkels.setImageResource(R.drawable.black_cirkel)


       tekst.setText("${rij},${kolom},${jeton.player}")

        return view


    }
}