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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mVerbruikViewModel = ViewModelProvider(this).get(VerbruiksViewModel::class.java)

        view.findViewById<TextView>(R.id.updateDatum).setText(args.currentVerbruik.datum)
        view.findViewById<TextView>(R.id.updatePils).setText(args.currentVerbruik.id.toString())
        view.findViewById<TextView>(R.id.updateDuvel).setText(args.currentVerbruik.duvel.toString())
        view.findViewById<TextView>(R.id.updateKwak).setText(args.currentVerbruik.kwak.toString())
        view.findViewById<TextView>(R.id.updateWestmalle)
            .setText(args.currentVerbruik.westmalle.toString())
        view.findViewById<TextView>(R.id.updateWijn).setText(args.currentVerbruik.wijn.toString())
        view.findViewById<TextView>(R.id.updateAnder).setText(args.currentVerbruik.ander.toString())
//..............................................................................................................................................

        view.findViewById<Button>(R.id.update_pasAan_button).setOnClickListener {
            val updateDatum = args.currentVerbruik.datum
            val verbruikToUpdate = updateVerbruik(updateDatum)


            mVerbruikViewModel.updateVerbruik(verbruikToUpdate)
            Toast.makeText(requireContext(), "Succesfully updated !", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
//..................................................................................................................................................

        view.findViewById<Button>(R.id.delete_button).setOnClickListener {

            val verbruikToDelete = Verbruik(
                args.currentVerbruik.datum,
                args.currentVerbruik.pils,
                args.currentVerbruik.duvel,
                args.currentVerbruik.wijn,
                args.currentVerbruik.westmalle,
                args.currentVerbruik.kwak,
                args.currentVerbruik.ander,
                args.currentVerbruik.id
            )
            mVerbruikViewModel.deleteVerbruik(verbruikToDelete)
            Toast.makeText(requireContext(), "Succesfully deleted !", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }
        return view
    }

    fun updateVerbruik(datum: String): Verbruik {
        val datum = datum
        var aantalPils = 0
        var aantalDuvel = 0
        var aantalWijn = 0
        var aantalWestMalle = 0
        var aantalKwak = 0
        var aantalAnder = 0

        val aantalPilsFound =
            view?.findViewById<EditText>(R.id.updatePils)?.text.toString()
        if (!TextUtils.isEmpty(aantalPilsFound)) {
             aantalPils = Integer.parseInt(aantalPilsFound)
        } else
            aantalPils = 0

        val aantalDuvelFound =
            view?.findViewById<EditText>(R.id.updateDuvel)?.text.toString()
        if (!TextUtils.isEmpty(aantalDuvelFound)) {
            aantalPils = Integer.parseInt(aantalDuvelFound)
        } else
            aantalDuvel = 0

        val aantalWijnFound =
            view?.findViewById<EditText>(R.id.updateWijn)?.text.toString()
        if (!TextUtils.isEmpty(aantalWijnFound)) {
            aantalPils = Integer.parseInt(aantalWijnFound)
        } else
            aantalWijn = 0

        val aantalWestmalleFound =
            view?.findViewById<EditText>(R.id.updateWestmalle)?.text.toString()
        if (!TextUtils.isEmpty(aantalWestmalleFound)) {
            aantalWestMalle = Integer.parseInt(aantalWestmalleFound)
        } else
            aantalWestMalle = 0

        val aantalKwakFound =
            view?.findViewById<EditText>(R.id.updateKwak)?.text.toString()
        if (!TextUtils.isEmpty(aantalKwakFound)) {
            aantalWestMalle = Integer.parseInt(aantalWestmalleFound)
        } else
            aantalKwak = 0

        val aantalAnderFound =
            view?.findViewById<EditText>(R.id.updateAnder)?.text.toString()
        if (!TextUtils.isEmpty(aantalAnderFound)) {
            aantalAnder = Integer.parseInt(aantalAnderFound)
        } else
            aantalAnder = 0

        val updatedVerbruik = Verbruik(
            datum, aantalPils, aantalDuvel, aantalWijn, aantalWestMalle, aantalKwak, aantalAnder, 0)

        return updatedVerbruik
    }
}

