package com.apoorav.clerror

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class fourth_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fourth_page)

        val fname  = intent.extras?.getString("fname") //first name
        val lname = intent.extras?.getString("lname") //last name
        val weight = intent.extras?.getString("weight") //weight
        val height = intent.extras?.getDouble("height") //height

        val w : Double? = weight?.toDouble()
        val h : Double? = height?.toDouble()

        val bmi : Double? = w?.div((h?.times(h)!!))

        val pbmi : Double = String.format("%.1f", bmi).toDouble()

        val txt : TextView = findViewById(R.id.wtxt)

        if (pbmi<=18.5){
            val disp_msg : String = "Your weight is $w KG and height is $h m. So your BMI is $pbmi. And this is considered as underweight."
            txt.text = disp_msg
        }
        else if (pbmi>=18.5 && pbmi<=24.9){
            val disp_msg : String = "Your weight is $w KG and height is $h m. So your BMI is $pbmi. And this is considered as Normal weight."
            Toast.makeText(this, "You're Perfect😍", Toast.LENGTH_SHORT).show()
            txt.text = disp_msg
        }
        else if (pbmi>=25.0 && pbmi<=30.0){
            val disp_msg : String = "Your weight is $w KG and height is $h m. So your BMI is $pbmi. And this is considered as Overweight."
            txt.text = disp_msg
        }
        else if (pbmi>=30.0){
            val disp_msg : String = "Your weight is $w KG and height is $h m. So your BMI is $pbmi. And this is considered as Obesity class."
            txt.text = disp_msg
        }


        val nbtn4 : Button = findViewById(R.id.nbtn4)
        nbtn4.setOnClickListener {
            val intent = Intent(this, final_page::class.java)
            startActivity(intent)
            finish()
        }
    }
}