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
import androidx.navigation.fragment.navArgs
import com.example.testpro.R
import com.example.testpro.Verbruik
import com.example.testpro.ui.main.VerbruiksViewModel


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mVerbruikViewModel: VerbruiksViewModel
    private lateinit var currentVerbruik: Verbruik
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)
        currentVerbruik = args.currentVerbruik
        mVerbruikViewModel = ViewModelProvider(this).get(VerbruiksViewModel::class.java)

        view.findViewById<TextView>(R.id.updateDatum).setText(currentVerbruik.datum)
        view.findViewById<TextView>(R.id.updatePils).setText(currentVerbruik.pils.toString())
        view.findViewById<TextView>(R.id.updateDuvel).setText(currentVerbruik.duvel.toString())
        view.findViewById<TextView>(R.id.updateKwak).setText(currentVerbruik.kwak.toString())
        view.findViewById<TextView>(R.id.updateWestmalle)
            .setText(currentVerbruik.westmalle.toString())
        view.findViewById<TextView>(R.id.updateWijn).setText(currentVerbruik.wijn.toString())
        view.findViewById<TextView>(R.id.updateAnder)
            .setText(currentVerbruik.anderNaam.toString())
//..............................................................................................................................................

        view.findViewById<Button>(R.id.update_pasAan_button).setOnClickListener {

            updateVerbruik()

            mVerbruikViewModel.updateVerbruik(currentVerbruik)
            Toast.makeText(requireContext(), "Succesfully updated !", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
//..................................................................................................................................................

        view.findViewById<Button>(R.id.delete_button).setOnClickListener {


            // args verbruik
            mVerbruikViewModel.deleteVerbruik(args.currentVerbruik)
            Toast.makeText(requireContext(), "Succesfully deleted !", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }

        return view
    }

    fun updateVerbruik() {

        val aantalPilsFound =
            view?.findViewById<EditText>(R.id.updatePils)?.text.toString()
        if (!TextUtils.isEmpty(aantalPilsFound)) {
            currentVerbruik.pils = Integer.parseInt(aantalPilsFound)
        }

        val aantalDuvelFound =
            view?.findViewById<EditText>(R.id.updateDuvel)?.text.toString()
        if (!TextUtils.isEmpty(aantalDuvelFound)) {
            currentVerbruik.duvel = Integer.parseInt(aantalDuvelFound)
        }

        val aantalWijnFound =
            view?.findViewById<EditText>(R.id.updateWijn)?.text.toString()
        if (!TextUtils.isEmpty(aantalWijnFound)) {
            currentVerbruik.wijn = Integer.parseInt(aantalWijnFound)
        }

        val aantalWestmalleFound =
            view?.findViewById<EditText>(R.id.updateWestmalle)?.text.toString()
        if (!TextUtils.isEmpty(aantalWestmalleFound)) {
            currentVerbruik.westmalle = Integer.parseInt(aantalWestmalleFound)
        }

        val aantalKwakFound =
            view?.findViewById<EditText>(R.id.updateKwak)?.text.toString()
        if (!TextUtils.isEmpty(aantalKwakFound)) {
            currentVerbruik.kwak = Integer.parseInt(aantalKwakFound)
        }

        val aantalAnderFound =
            view?.findViewById<EditText>(R.id.updateAnder)?.text.toString()
        if (!TextUtils.isEmpty(aantalAnderFound)) {
            currentVerbruik.anderAantal = aantalAnderFound.toInt()
        }


    }
}

