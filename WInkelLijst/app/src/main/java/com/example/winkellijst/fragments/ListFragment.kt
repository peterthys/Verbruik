package com.example.winkellijst.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.winkellijst.R
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        view.fab_add.setOnClickListener {
            Toast.makeText(requireContext(), "Updated !", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }


}