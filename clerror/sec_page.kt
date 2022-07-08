package com.apoorav.clerror

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class sec_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sec_page)

        dateBtn()
    }

    fun dateBtn() {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        val age = intent.extras?.getString("age") //age
        val sday = intent.extras?.getInt("sday") //selected day
        val smonth = intent.extras?.getInt("smonth") //selected month
        val syear = intent.extras?.getInt("syear") //selected year
        val fname  = intent.extras?.getString("fname") //first name
        val lname = intent.extras?.getString("lname") //last name
        val gender = intent.extras?.getString("gender") //gender
        val blood = intent.extras?.getString("blood") //blood Group
        val weight = intent.extras?.getString("weight") //weight
        val height = intent.extras?.getInt("height") //height

        val gender1 = gender?.get(0)?.toInt()
        val txt : TextView = findViewById(R.id.txt)


        if (month == smonth && day == sday) {
            val disp_msg = "Hey! $fname $lname. Wish you a Very Cheerfull Birthday. You were born in $syear. You are ${age.toString()} old. You are the reason of your mother's HAPPINESS."
            txt.text = disp_msg
            if (gender1 == 102 || gender1 == 70) {
                Toast.makeText(this, "Happy Birthday Beautifull🥳", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Happy Birthday Handsome🥳", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            val disp_msg = "Hey! $fname $lname. You were born in $syear. You are ${age.toString()} old. You are the reason of your mother's HAPPINESS."
            txt.text = disp_msg
        }

        val nbtn2 : Button ?= findViewById(R.id.nbtn2)
        nbtn2?.setOnClickListener {
            val intent = Intent(this, third_activity::class.java).apply {
                putExtra("fname", fname)
                putExtra("lname", lname)
                putExtra("sday", sday)
                putExtra("smonth", smonth)
                putExtra("syear", syear)
                putExtra("age", age)
                //putExtra("gender", gender)
                putExtra("blood", blood)
                putExtra("weight", weight)
                putExtra("height", height)
            }
            startActivity(intent)
            finish()
        }


    }
}