package com.marcioz.gascalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun calcPrice(view: View){ // Always* inherit the class with views

        val gasoline = gasEntry.text.toString()
        val alcohol = alcoholEntry.text.toString()

        val validateFields = validateFields(gasoline, alcohol)

        if (validateFields){
            bestPrice(gasoline, alcohol)

        }else{
            textView2.text = "Fill empty fields please"
        }

        }

    private fun validateFields(gasoline: String, alcohol:String): Boolean {

        var toValidate: Boolean = true

        if (gasoline == null || alcohol == "") {
            toValidate = false
        }
        else if (alcohol == null || gasoline == "") {
            toValidate = false
        }
        return toValidate
    }


    private fun bestPrice(gasoline:String, alcohol: String){

        val g = gasoline.toDouble()
        val a = alcohol.toDouble()
        val result: Double = a /g

        if (result >= 0.7) {
            textView2.text = "The best is gasoline"
        } else {
            textView2.text = "The best is alcohol"
        }
    }
}