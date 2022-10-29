package com.example.winkellijst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.winkellijst.data.BoodschapViewmodel

class MainActivity : AppCompatActivity() {
    private lateinit var mBoodschapViewModel: BoodschapViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBoodschapViewModel = ViewModelProvider(this).get(BoodschapViewmodel::class.java)


//setupActionBarWithNavController(findNavController(R.id.fragment))
//
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.fragment)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
    }
}