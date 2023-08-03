package com.example.testpro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView.*
import com.example.testpro.ui.main.fragments.ListFragment
import com.example.testpro.ui.main.fragments.ListFragmentDirections


class ListAdapter : Adapter<ListAdapter.MyViewHolder>() {

    private var verbruiksList = emptyList<Verbruik>()

    class MyViewHolder(itemView: View) : ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return verbruiksList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var resultaat = 0
        val currentVerbruik = verbruiksList[position]
        holder.itemView.findViewById<TextView>(R.id.tv_datum).text = currentVerbruik.datum


        val pilsVerbruik = currentVerbruik.pils
        resultaat = resultaat + (pilsVerbruik * 108)
        if (pilsVerbruik == 0) {
            holder.itemView.findViewById<TextView>(R.id.tv_pils).visibility = GONE
        } else {
            holder.itemView.findViewById<TextView>(R.id.tv_pils).text =
                "pils : $pilsVerbruik"
        }

        val duvelVerbruik = currentVerbruik.duvel
        resultaat = resultaat + (duvelVerbruik * 211)
        if (duvelVerbruik == 0) {
            holder.itemView.findViewById<TextView>(R.id.tv_duvel).visibility = GONE
        } else {
            holder.itemView.findViewById<TextView>(R.id.tv_duvel).text =
                "duvel : $duvelVerbruik"
        }

        val wijnVerbruik = currentVerbruik.wijn
        resultaat = resultaat + (wijnVerbruik * 140)
        if (wijnVerbruik == 0) {
            holder.itemView.findViewById<TextView>(R.id.tv_wijn).visibility = GONE
        } else
            holder.itemView.findViewById<TextView>(R.id.tv_wijn).text =
                "wijn : $wijnVerbruik"

        val westmalleVerbruik = currentVerbruik.westmalle
        resultaat = resultaat + (westmalleVerbruik * 245)
        if (westmalleVerbruik == 0) {
            holder.itemView.findViewById<TextView>(R.id.tv_westmalle).visibility = GONE
        } else
            holder.itemView.findViewById<TextView>(R.id.tv_westmalle).text =
                "westmalle : $westmalleVerbruik"

        val kwakVerbruik = currentVerbruik.kwak
        resultaat = resultaat + (kwakVerbruik * 214)
        if (kwakVerbruik == 0) {
            holder.itemView.findViewById<TextView>(R.id.tv_kwak).visibility = GONE
        } else
            holder.itemView.findViewById<TextView>(R.id.tv_kwak).text =
                "kwak : $kwakVerbruik"

        val anderVerbruik = currentVerbruik.ander
        resultaat = resultaat + anderVerbruik
        if (anderVerbruik == 0) {
            holder.itemView.findViewById<TextView>(R.id.tv_ander).visibility = GONE
        } else
            holder.itemView.findViewById<TextView>(R.id.tv_ander).text =
                "ander : $anderVerbruik"


        holder.itemView.findViewById<TextView>(R.id.tv_resultaat).text =
            "$resultaat kcal"

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentVerbruik)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(verbruiksLijst: List<Verbruik>) {
        this.verbruiksList = verbruiksLijst
        notifyDataSetChanged()

    }

}
