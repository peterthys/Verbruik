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
import com.example.testpro.R
import com.example.testpro.Verbruik

import com.example.testpro.ui.main.VerbruiksViewModel
import java.text.SimpleDateFormat
import java.util.Calendar


class AddFragment : Fragment() {

private lateinit var mVerbruikViewModel : VerbruiksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mVerbruikViewModel= ViewModelProvider(this).get(VerbruiksViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_add, container, false)

        val dateOfYear = Calendar.getInstance()
        val dateFormat= SimpleDateFormat("dd/MM")
        val dateTime = dateFormat.format(dateOfYear.time).toString()
        val datum = view?.findViewById<TextView>(R.id.addDatum)
        datum?.text= dateTime
        val verbruiksDatum = dateTime

        val btn = view.findViewById<Button>(R.id.add_button)
        btn.setOnClickListener{
            addVerbruikToDatabase(verbruiksDatum)
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }


        return view
    }

    private fun addVerbruikToDatabase(verbruiksDatum: String) {
        val datum = verbruiksDatum
 //       var aantalPils = view?.findViewById<EditText>(R.id.updatePils)?.text
//        var aantalPilsVoorDatabase = Integer.parseInt(aantalPils.toString())
      //  if (aantalPils==null){aantalPils= 0
       // }
    //    var aantalDuvel = (view?.findViewById<EditText>(R.id.updateDuvel)?.text)
   //     var aantalDuvelVoorDatabase =  Integer.parseInt(aantalDuvel.toString())
      //  if (aantalDuvel==""){aantalDuvel= 0.toString()
      //  }
//        var aantalWestmalle = view?.findViewById<EditText>(R.id.updateWestmalle)?.text.toString()
 //       var aantalWestmalleVoorDatabase =  Integer.parseInt(aantalWestmalle.toString())
     //   if (aantalWestmalle==""){
      //      aantalWestmalle = 0.toString()
       // }
//        var aantalWijn = view?.findViewById<EditText>(R.id.updateWijn)?.text.toString()
//        var aantalWijnVoorDatabase =  Integer.parseInt(aantalWijn.toString())
//        if (aantalWijn==""){
//             aantalWijn = 0.toString()
//        }
  //      var aantalKwak = view?.findViewById<EditText>(R.id.updateKwak)?.text.toString()
 //       var aantalKwakVoorDatabase =  Integer.parseInt(aantalKwak.toString())
//        if (aantalKwak==""){
//            aantalKwak = 0.toString()
//        }
 //       var aantalAnder = view?.findViewById<EditText>(R.id.updateAnder)?.text.toString()
//        var aantalAnderVoorDatabase =  Integer.parseInt(aantalAnder.toString())
//        if (aantalAnder==""){
//            aantalAnder = 0.toString()
//        }
val verbrruik = Verbruik(datum,1,1,1,1,1,1,0)
//        val verbruik = Verbruik(
//            datum,
//            (aantalPilsVoorDatabase),
//            (aantalDuvelVoorDatabase),
//            (aantalWestmalleVoorDatabase),
//            (aantalWijnVoorDatabase),
//            (aantalKwakVoorDatabase),
//            (aantalAnderVoorDatabase),
//            0
//        )
        mVerbruikViewModel.addVerbruik(verbrruik)
        Toast.makeText(requireContext(),"Succesfully added !",Toast.LENGTH_LONG).show()
    }


}