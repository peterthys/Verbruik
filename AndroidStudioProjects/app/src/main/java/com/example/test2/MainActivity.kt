package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

private var x = 5
private var a = 1
private var b = 2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (x>a){
            Toast.makeText(applicationContext, "if", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(applicationContext, "else", Toast.LENGTH_LONG).show()
        }


}}