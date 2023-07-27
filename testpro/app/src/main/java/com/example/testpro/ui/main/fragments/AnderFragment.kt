package com.example.testpro.ui.main.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testpro.Ander
import com.example.testpro.R
import com.example.testpro.R.id.action_anderFragment_to_addFragment


class AnderFragment : Fragment() {
    private var currentAnder = Ander("0", 0, 0, 0, 0, 0)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ander, container, false)

        val RadioGroupAnder = view.findViewById<RadioGroup>(R.id.radioGroup)
//        onRadioButtonClicked(RadioGroupAnder)
        val terugButton = view?.findViewById<Button>(R.id.bt_return_to_add)
        terugButton?.setOnClickListener {
            findNavController().navigate(action_anderFragment_to_addFragment)
        }
        val currentCal = view.findViewById<EditText>(R.id.et_calAnder).text
        val currentAantal = view.findViewById<EditText>(R.id.et_aantalAnder).text

        berekenNieuweAnder(currentAantal, currentCal)
        return view

    }

    fun berekenNieuweAnder(currentAantal: Editable, currentCal: Editable) {
        val cal: Int
        val aantal: Int
        val currentName = view?.findViewById<EditText>(R.id.et_naamAnder)?.text.toString()

        if (TextUtils.isEmpty(currentAantal)) {
            aantal = 0
        } else
            aantal = Integer.parseInt(currentAantal.toString())

        if (TextUtils.isEmpty(currentCal)) {
            cal = 0
        } else
            cal = Integer.parseInt(currentCal.toString())

        if (onRadioButtonClicked(view)==1){
            currentAnder.glazen = 1
        }else
            if (onRadioButtonClicked(view)==2){
            currentAnder.cl25 = 1
        }else {
            currentAnder.cl33 = 1
        }

        currentAnder =
            Ander(currentName, 1, 1, 1, aantal, cal)
    }


    fun onRadioButtonClicked(view: View?): Int {


        var keuze: Int = 0
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked


            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_glas ->
                    if (checked) {
                        keuze = 1
                    }
                R.id.radio_25 ->
                    if (checked) {
                        keuze = 2
                    }
                R.id.radio_33 ->
                    if (checked) {
                        keuze = 3
                    }
        }
    }
        return keuze
    }
}