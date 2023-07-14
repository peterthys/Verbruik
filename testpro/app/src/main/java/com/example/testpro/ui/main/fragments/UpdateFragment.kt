package com.example.testpro.ui.main.fragments

import android.os.Bundle
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
        view.findViewById<Button>(R.id.delete_button).setOnClickListener {
  //          val updateDatum = args.currentVerbruik.datum
 //           updateVerbruik(updateDatum)
            val verbruikToDelete = Verbruik(
                args.currentVerbruik.datum,
                args.currentVerbruik.pils,
                args.currentVerbruik.duvel,
                args.currentVerbruik.wijn,
                args.currentVerbruik.westmalle,
                args.currentVerbruik.kwak,
                args.currentVerbruik.ander,
                args.currentVerbruik.id)
            mVerbruikViewModel.deleteVerbruik(verbruikToDelete)
            Toast.makeText(requireContext(), "Succesfully deleted !", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }
        return view
    }

//    private fun updateVerbruik(datum: String) {
//        //val datum = datum
//        var aantalPils = view?.findViewById<EditText>(R.id.updatePils)?.text.toString()
//        if (aantalPils == "") {
//            aantalPils = 0.toString()
//        }
//        var aantalDuvel = view?.findViewById<EditText>(R.id.updateDuvel)?.text.toString()
//        if (aantalDuvel == "") {
//            aantalDuvel = 0.toString()
//        }
//        var aantalWestmalle = view?.findViewById<EditText>(R.id.updateWestmalle)?.text.toString()
//        if (aantalWestmalle == "") {
//            aantalWestmalle = 0.toString()
//        }
//        var aantalWijn = view?.findViewById<EditText>(R.id.updateWijn)?.text.toString()
//        if (aantalWijn == "") {
//            aantalWijn = 0.toString()
//        }
//        var aantalKwak = view?.findViewById<EditText>(R.id.updateKwak)?.text.toString()
//        if (aantalKwak == "") {
//            aantalKwak = 0.toString()
//        }
//        var aantalAnder = view?.findViewById<EditText>(R.id.updateAnder)?.text.toString()
//        if (aantalAnder == "") {
//            aantalAnder = 0.toString()
//        }
//
//        val updatedVerbruik = Verbruik(
//            args.currentVerbruik.datum,
//            aantalPils.toInt(),
//            aantalDuvel.toInt(),
//            aantalWestmalle.toInt(),
//            aantalWijn.toInt(),
//            aantalKwak.toInt(),
//            aantalAnder.toInt(),
//            id = 0
//        )
//    }
}

