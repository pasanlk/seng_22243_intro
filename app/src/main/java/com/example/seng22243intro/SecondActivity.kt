package com.example.seng22243intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val buttonSecondActivity = findViewById<Button>(R.id.button_secondActivity)
        val textViewSecondActivity = findViewById<TextView>(R.id.textview_secondActivity)

        buttonSecondActivity.setOnClickListener(){
            textViewSecondActivity.text= "pasan lahiru"
        }
    }
}