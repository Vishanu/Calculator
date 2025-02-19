package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private var tvInput: TextView?=null
    var lastNumeric: Boolean = false
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
    }

    fun onDigit(view: View){
//        Toast.makeText(this,"Button clicker",Toast.LENGTH_LONG).show()
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDot = false

    }

    fun onClear(view: View){
        tvInput?.text = ""
    }
    fun onClearOne(view: View) {
        val currentText = tvInput?.text.toString()
        if (currentText.isNotEmpty()) {
            tvInput?.text = currentText.substring(0, currentText.length - 1)
        }
    }
    fun onDecimalPoint(view: View){
        if(lastNumeric && !lastDot){
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View){
        tvInput?.text?.let {
            if(lastNumeric && !isOperatorAdded(it.toString())) {
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }

        }
    }

    fun onEqual(view: View){
        if(lastNumeric){
            var tvValue = tvInput?.text.toString()
        }
    }

    private fun isOperatorAdded(value: String): Boolean{
        return if(value.startsWith("-")) {
            false
        }else{
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
        }
    }
}