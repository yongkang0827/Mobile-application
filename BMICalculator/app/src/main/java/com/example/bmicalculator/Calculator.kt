package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Calculator : AppCompatActivity() {
    var bmiIndex: Double = 0.0


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

            val height = findViewById<EditText>(R.id.editTextWeight).text.toString()
            val weight = findViewById<EditText>(R.id.editTextWeight).text.toString()
            val tvStatus = findViewById<TextView>(R.id.textResult)

            bmiIndex = weight.toDouble() / (height.toDouble() * height.toDouble())

            tvStatus.setText(getStatus())
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmiIndex", bmiIndex)
    }

    private fun getStatus(): String {
        if (bmiIndex < 18.5) {
            return "underweight"
        } else if (bmiIndex>18.5 && bmiIndex < 24.9) {
            return "Normal weight"
        } else if (bmiIndex>24.9 && bmiIndex < 29.9) {
            return "Overweight"
        } else if (bmiIndex>29.9 && bmiIndex < 34.9) {
            return "Obesity class I"
        } else if (bmiIndex>34.9 && bmiIndex < 39.9) {
            return "Obesity class II"
        }

        return " Obesity class III"

    }
}
