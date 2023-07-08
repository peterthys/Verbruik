package com.example.testpro.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testpro.ListAdapter
import com.example.testpro.R
import com.example.testpro.ui.main.VerbruiksViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {

    private lateinit var mVerbruikViewModel: VerbruiksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val adapter = ListAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mVerbruikViewModel = ViewModelProvider(this).get(VerbruiksViewModel::class.java)
        mVerbruikViewModel.readAllVerbruik.observe(viewLifecycleOwner, Observer { verbruik ->
            adapter.setData(verbruik)
        })

        val btn = view.findViewById<FloatingActionButton>(R.id.fabAdd)
        btn.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }


}