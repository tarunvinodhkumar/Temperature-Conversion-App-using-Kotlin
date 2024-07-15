package com.example.calculations

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val resultTV: TextView = findViewById(R.id.textResult)
        val spinnerVal: Spinner = findViewById(R.id.spSelect)

        // Options for temperature conversion
        val options = arrayOf("Celsius to Fahrenheit", "Fahrenheit to Celsius")
        spinnerVal.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, options)

        button.setOnClickListener {
            val inputTemperature = edtxt1.text.toString().toFloatOrNull()
            if (inputTemperature == null) {
                Toast.makeText(this, "Please enter a valid temperature", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Perform selected conversion
            val selectedOption = spinnerVal.selectedItemPosition
            val convertedTemperature: Float = when (selectedOption) {
                0 -> celsiusToFahrenheit(inputTemperature)
                1 -> fahrenheitToCelsius(inputTemperature)
                else -> 0.0f
            }

            resultTV.text = String.format("%.2f", convertedTemperature)
        }
    }

    private fun celsiusToFahrenheit(celsius: Float): Float {
        return (celsius * 9 / 5) + 32
    }

    private fun fahrenheitToCelsius(fahrenheit: Float): Float {
        return (fahrenheit - 32) * 5 / 9
    }
}