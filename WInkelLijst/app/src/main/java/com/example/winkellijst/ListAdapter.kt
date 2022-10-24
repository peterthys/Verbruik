package com.example.winkellijst

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.winkellijst.data.Boodschap
import com.example.winkellijst.fragments.ListFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter (boodschap: Boodschap,

    private val listener : OnItemClickListener) :
    RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private  var itemsList = emptyList<Boodschap>()
    lateinit var listFragment : ListFragment

    var singleitem_selection_position = -1

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener
     {
        init {
            itemView.setOnClickListener (this)
//            {
//                setSingleSelection(adapterPosition)
//            }

        }

         override fun onClick(v: View?) {
             val position = absoluteAdapterPosition
             val dezeBoodschap = itemsList[position].productsName
             val boodschapId = itemsList[position].id
             val boodschapToDelete = Boodschap (boodschapId,dezeBoodschap)


             if (position != RecyclerView.NO_POSITION) {

                 listener.onItemClick(boodschapToDelete)
             }
         }
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        listFragment= ListFragment()
        val currentItem = itemsList[position]
        holder.itemView.tv_id.text = currentItem.id.toString()
        holder.itemView.tv_itemName.text = currentItem.productsName
        if (singleitem_selection_position == position) {

            holder.itemView.setBackgroundColor(Color.GRAY)
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT)
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    fun setData(boodschap: List<Boodschap>) {
        this.itemsList = boodschap
        notifyDataSetChanged()
    }

    private fun setSingleSelection(adapterPosition: Int) {
        if (adapterPosition == RecyclerView.NO_POSITION) return
        notifyItemChanged(singleitem_selection_position)
        singleitem_selection_position = adapterPosition
        notifyDataSetChanged()
    }
//    override fun onCreateDialog(savedInstanceState: Bundle?)
//    fun deleteBoodschap(){
//        override fun onCreatedialog
//        val builder = AlertDialog.Builder(requireContext())
//        builder.setPositionButton("yes") { _, _ ->
//
//        }
//    }
    interface OnItemClickListener{
        fun onItemClick(boodschap: Boodschap)
    }
}


