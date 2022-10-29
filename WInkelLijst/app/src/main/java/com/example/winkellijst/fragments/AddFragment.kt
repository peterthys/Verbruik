package com.example.winkellijst.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.winkellijst.R
import com.example.winkellijst.data.Boodschap
import com.example.winkellijst.data.BoodschapViewmodel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {
    private lateinit var mBoodschapViewModel: BoodschapViewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        mBoodschapViewModel = ViewModelProvider(this).get(BoodschapViewmodel::class.java)

        view.btn_add_to_list.setOnClickListener {
            insertItemToDataBase()

        }

        return view
    }

    private fun insertItemToDataBase() {
        val itemDiscription = et_item.text.toString()
        if (inputCheck(itemDiscription)){
            val item = Boodschap(id=0,itemDiscription)
            mBoodschapViewModel.addItem(item)
            Toast.makeText(requireContext(),"Succesfully added!",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
else{
    Toast.makeText(requireContext(),"Fill in an item!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(itemDiscription: String): Boolean {
        return !(TextUtils.isEmpty(itemDiscription))

    }
}