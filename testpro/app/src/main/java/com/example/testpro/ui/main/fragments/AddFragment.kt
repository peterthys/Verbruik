package com.example.testpro.ui.main.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testpro.R
import com.example.testpro.Verbruik

import com.example.testpro.ui.main.VerbruiksViewModel
import java.text.SimpleDateFormat
import java.util.Calendar


class AddFragment : Fragment() {

    private lateinit var mVerbruikViewModel: VerbruiksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mVerbruikViewModel = ViewModelProvider(this).get(VerbruiksViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_add, container, false)

        val dateOfYear = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd/MM")
        val dateTime = dateFormat.format(dateOfYear.time).toString()
        val datum = view?.findViewById<TextView>(R.id.addDatum)
        datum?.text = dateTime
        val verbruiksDatum = dateTime

        val btn = view.findViewById<Button>(R.id.add_button)
        btn.setOnClickListener {
            addVerbruikToDatabase(verbruiksDatum)
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }


        return view
    }

    private fun addVerbruikToDatabase(verbruiksDatum: String) {
        var aantalPilsVoorDatabase = 0
        var aantalDuvelVoorDatabase = 0
        var aantalWijnVoorDatabase = 0
        var aantalWestmalleVoorDatabase = 0
        var aantalKwakVoorDatabase = 0
        var aantalAnderVoorDatabase = 0


        val datum = verbruiksDatum
        val aantalPils = view?.findViewById<EditText>(R.id.addPils)?.text
        if (TextUtils.isEmpty(aantalPils)) {
            aantalPilsVoorDatabase = 0
        } else
            aantalPilsVoorDatabase = Integer.parseInt(aantalPils.toString())

        val aantalDuvel = (view?.findViewById<EditText>(R.id.addDuvel)?.text)
        if (TextUtils.isEmpty(aantalDuvel)) {
            aantalDuvelVoorDatabase = 0
        } else
            aantalDuvelVoorDatabase = Integer.parseInt(aantalPils.toString())

        var aantalWestmalle = view?.findViewById<EditText>(R.id.addWestmalle)?.text.toString()
        if (TextUtils.isEmpty(aantalWestmalle)) {
            aantalWestmalleVoorDatabase = 0
        } else
            aantalWestmalleVoorDatabase = Integer.parseInt(aantalWestmalle.toString())

        var aantalWijn = view?.findViewById<EditText>(R.id.addWijn)?.text.toString()
        if (TextUtils.isEmpty(aantalWijn)) {
            aantalWijnVoorDatabase = 0
        } else
            aantalWijnVoorDatabase = Integer.parseInt(aantalWijn.toString())

        var aantalKwak = view?.findViewById<EditText>(R.id.addKwak)?.text.toString()
        if (TextUtils.isEmpty(aantalKwak)) {
            aantalKwakVoorDatabase = 0
        } else
            aantalKwakVoorDatabase = Integer.parseInt(aantalPils.toString())

        var aantalAnder = view?.findViewById<EditText>(R.id.addAnder)?.text.toString()
        if (TextUtils.isEmpty(aantalAnder)) {
            aantalAnderVoorDatabase = 0
        } else
            aantalAnderVoorDatabase = Integer.parseInt(aantalPils.toString())

        val verbruik =
            Verbruik(
                datum,
                aantalPilsVoorDatabase,
                aantalDuvelVoorDatabase,
                aantalWijnVoorDatabase,
                aantalWestmalleVoorDatabase,
                aantalKwakVoorDatabase,
                aantalAnderVoorDatabase,
                0
            )

        mVerbruikViewModel.addVerbruik(verbruik)
        Toast.makeText(requireContext(), "Succesfully added !", Toast.LENGTH_LONG).show()
    }


}