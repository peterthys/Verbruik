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
    private var inhoudAnderVoorDatabase = 0.0

    // private val args : AddFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        mVerbruikViewModel = ViewModelProvider(this).get(VerbruiksViewModel::class.java)


//        var glazenAnder = args.currentAnder.glazen
//        var cl25Ander = args.currentAnder.cl25
//        var cl33Ander = args.currentAnder.cl33
//        var aantAnder = args.currentAnder.aantal
//        var calAnder = args.currentAnder.caloriePerHonderdMl

        val dateOfYear = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd/MM")
        val dateTime = dateFormat.format(dateOfYear.time).toString()
        val datum = view?.findViewById<TextView>(R.id.addDatum)
        datum?.text = dateTime

        val anderNaam = view.findViewById<EditText>(R.id.addAnder_naam)
        val anderGlas = view.findViewById<TextView>(R.id.addAnder_glas_button)
        val andercl25 = view.findViewById<TextView>(R.id.addAnder_cl25_button)
        val andercl33 = view.findViewById<TextView>(R.id.addAnder_cl33_button)
        val anderCal = view.findViewById<EditText>(R.id.addAnder_cal)
        val anderAantal = view.findViewById<EditText>(R.id.addAnder_aantal)
        anderNaam.visibility = View.GONE
        anderGlas.visibility = View.GONE
        andercl25.visibility = View.GONE
        andercl33.visibility = View.GONE
        anderCal.visibility = View.GONE
        anderAantal.visibility = View.GONE


        val btn = view.findViewById<Button>(R.id.add_button)
        btn.setOnClickListener {
            addVerbruikToDatabase(dateTime)
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        val anderView = view.findViewById<TextView>(R.id.addAnder)
        anderView.setOnClickListener {
            anderView.visibility = View.GONE
            anderNaam.visibility = View.VISIBLE
            anderGlas.visibility = View.VISIBLE
            andercl25.visibility = View.VISIBLE
            andercl33.visibility = View.VISIBLE
            anderCal.visibility = View.VISIBLE
            anderAantal.visibility = View.VISIBLE

        }


        anderGlas?.setOnClickListener {

            inhoudAnderVoorDatabase = 1.2
            Toast.makeText(requireContext(), "glas gedrukt !", Toast.LENGTH_LONG).show()
        }
        andercl25?.setOnClickListener {
            inhoudAnderVoorDatabase = 2.5
        }
        andercl33?.setOnClickListener {
            inhoudAnderVoorDatabase = 3.3
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
        var naamAnderVoorDatabase = ""

        var calAnderVoorDatabase = 0


        val datum = verbruiksDatum

        val aantalPils = view?.findViewById<EditText>(R.id.addPils)?.text
        if (TextUtils.isEmpty(aantalPils)) {
            aantalPilsVoorDatabase = 0
        } else
            aantalPilsVoorDatabase = Integer.parseInt(aantalPils.toString())

        val aantalDuvel = (view?.findViewById<EditText>(R.id.addDuvel)?.text)
        if (TextUtils.isEmpty(aantalDuvel)) {
            aantalDuvelVoorDatabase = 0
        } else {
            aantalDuvelVoorDatabase = Integer.parseInt(aantalDuvel.toString())
        }

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
            aantalKwakVoorDatabase = Integer.parseInt(aantalKwak.toString())

        var aantalAnder = view?.findViewById<EditText>(R.id.addAnder_aantal)?.text.toString()
        if (TextUtils.isEmpty(aantalAnder)) {
            aantalAnderVoorDatabase = 0
        } else
            aantalAnderVoorDatabase = Integer.parseInt(aantalAnder.toString())

        var naamAnder = view?.findViewById<EditText>(R.id.addAnder_naam)?.text.toString()
        if (TextUtils.isEmpty(naamAnder)) {
            naamAnderVoorDatabase = ""
        } else
            naamAnderVoorDatabase = naamAnder


        var anderCal = view?.findViewById<EditText>(R.id.addAnder_cal)?.text.toString()
        if (TextUtils.isEmpty(anderCal)) {
            calAnderVoorDatabase = 0
        } else
            calAnderVoorDatabase = Integer.parseInt(anderCal.toString())

        val verbruik =
            Verbruik(
                datum,
                aantalPilsVoorDatabase,
                aantalDuvelVoorDatabase,
                aantalWijnVoorDatabase,
                aantalWestmalleVoorDatabase,
                aantalKwakVoorDatabase,
                aantalAnderVoorDatabase,
                naamAnderVoorDatabase,
                inhoudAnderVoorDatabase,
                calAnderVoorDatabase,
                0
            )
        if (!(aantalPilsVoorDatabase == 0 || aantalDuvelVoorDatabase == 0 || aantalWijnVoorDatabase == 0 || aantalWestmalleVoorDatabase == 0 || aantalKwakVoorDatabase == 0 || (aantalAnderVoorDatabase == 0 && naamAnderVoorDatabase == "" && inhoudAnderVoorDatabase == 0.0 && calAnderVoorDatabase == 0))) {



        mVerbruikViewModel.addVerbruik(verbruik)
        Toast.makeText(requireContext(), "Succesfully added !", Toast.LENGTH_LONG).show()
    }
        else {
            Toast.makeText(
                requireContext(),
                "Alles is leeg, vul tenminste één drankverbruik in !",
                Toast.LENGTH_LONG
            ).show()

        }
    }


}