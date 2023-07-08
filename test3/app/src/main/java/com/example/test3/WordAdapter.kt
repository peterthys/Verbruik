package com.example.test3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordAdapter  (private val wordList : MutableList<Word>
): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {



    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {

        val currentWord = wordList[position]
//        holder.itemView.tvTextView.text = currentWord.toString()
//tvT

    }
}
