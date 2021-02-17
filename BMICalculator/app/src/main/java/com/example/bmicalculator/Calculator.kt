package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Calculator : AppCompatActivity() {
    private var bmiIndex: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val personName = intent?.getStringExtra("personName")
        val tv = findViewById<TextView>(R.id.textName)

        tv.setText(personName)

        if (savedInstanceState != null) {
            bmiIndex = savedInstanceState.getDouble("bmiIndex")

            val tvStatus = findViewById<TextView>(R.id.textResult)
            tvStatus.setText(getStatus())
        }

        val btn = findViewById<Button>(R.id.buttonCalculate)

        btn.setOnClickListener() {

            val height = findViewById<EditText>(R.id.editTextHeight).text.toString().toDouble()
            val weight = findViewById<EditText>(R.id.editTextWeight).text.toString().toDouble()
            val tvStatus = findViewById<TextView>(R.id.textResult)

            bmiIndex = weight / (height * height)

            tvStatus.text=getStatus()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmiIndex", bmiIndex)
    }

    private fun getStatus(): String {
        when {
            bmiIndex < 18.5 -> {
                return "underweight"
            }
            bmiIndex in 18.5..24.9 -> {
                return "Normal weight"
            }
            bmiIndex in 24.9..29.9 -> {
                return "Overweight"
            }
            bmiIndex in 29.9..34.9 -> {
                return "Obesity class I"
            }
            bmiIndex in 34.9..39.9 -> {
                return "Obesity class II"
            }
            else -> return " Obesity class III"
        }

    }
}
