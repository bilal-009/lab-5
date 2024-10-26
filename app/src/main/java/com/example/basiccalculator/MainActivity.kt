package com.example.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edit_text_1: EditText
    private lateinit var edit_text_2: EditText
    private lateinit var btn_add: Button
    private lateinit var btn_sub: Button
    private lateinit var btn_mul: Button
    private lateinit var btn_div: Button
    private lateinit var result_TV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        edit_text_1 = findViewById(R.id.edit1)
        edit_text_2 = findViewById(R.id.edit2)
        btn_add = findViewById(R.id.btn_add)
        btn_sub = findViewById(R.id.btn_sub)
        btn_mul = findViewById(R.id.btn_mul)
        btn_div = findViewById(R.id.btn_div)
        result_TV = findViewById(R.id.result)

        // Set click listeners for all buttons
        btn_add.setOnClickListener(this)
        btn_sub.setOnClickListener(this)
        btn_mul.setOnClickListener(this)
        btn_div.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // Get input values and handle potential parsing errors
        val ed_1 = edit_text_1.text.toString().toDoubleOrNull() ?: 0.0
        val ed_2 = edit_text_2.text.toString().toDoubleOrNull() ?: 0.0
        var result = 0.0

        // Determine which button was clicked
        when (v?.id) {
            R.id.btn_add -> result = ed_1 + ed_2
            R.id.btn_sub -> result = ed_1 - ed_2
            R.id.btn_mul -> result = ed_1 * ed_2
            R.id.btn_div -> {
                result = if (ed_2 != 0.0) ed_1 / ed_2 else Double.NaN // Avoid division by zero
            }
        }

        // Display the result
        result_TV.text = if (result.isNaN()) "Cannot divide by zero" else "Result is $result"
    }
}
