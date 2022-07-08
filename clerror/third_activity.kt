package com.apoorav.clerror

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class third_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_page)

        val age = intent.extras?.getString("age") //age
        val sday = intent.extras?.getInt("sday") //selected day
        val smonth = intent.extras?.getInt("smonth") //selected month
        val syear = intent.extras?.getInt("syear") //selected year
        val fname  = intent.extras?.getString("fname") //first name
        val lname = intent.extras?.getString("lname") //last name
        //val gender = intent.extras?.getString("gender") //gender
        val blood = intent.extras?.getString("blood")?.toUpperCase() //Blood Group
        val weight = intent.extras?.getString("weight") //weight
        val height1 = intent.extras?.getInt("height")?.toDouble() //height
        val height = height1?.div(100)

        var disp_msge : String = "Please Enter valid Blood Group"
        if (blood == "O+"){
            disp_msge = "You are a universal DONOR😎. You can donate to all the other positive blood group patients. But you can receive Blood from O+ group persons only."
            Toast.makeText(this, "O+ blood", Toast.LENGTH_SHORT).show()
        }
        else if (blood == "A+"){
            disp_msge = "You have second most common Blood group. You can donate to A+ and AB+ blood group patients. But you can receive Blood from O and A groups persons."
            Toast.makeText(this, "A+ blood", Toast.LENGTH_SHORT).show()
        }
        else if (blood == "B+"){
            disp_msge = "You can donate to B+ and AB+ blood group patients. But you can receive Blood from O and B groups persons."
            Toast.makeText(this, "B+ blood", Toast.LENGTH_SHORT).show()
        }
        else if (blood == "AB+"){
            disp_msge = "You are universal RECIPIENT😇. You can donate to AB+ blood group patients only. But you can receive Blood from any other blood groups persons."
            Toast.makeText(this, "AB+ blood", Toast.LENGTH_SHORT).show()
        }
        else if (blood == "O-"){
            disp_msge = "You are a universal DONOR😎. You can donate to all the other blood group patients. But you can receive Blood from O- group persons only."
            Toast.makeText(this, "O- blood", Toast.LENGTH_SHORT).show()
        }
        else if (blood == "A-"){
            disp_msge = "You have second most common Blood group. You can donate to A and AB blood groups patients. But you can receive Blood from O- and A- group persons."
            Toast.makeText(this, "A- blood", Toast.LENGTH_SHORT).show()
        }
        else if (blood == "B-"){
            disp_msge = "You can donate to B and AB blood groups patients. But you can receive Blood from O- and B- group persons."
            Toast.makeText(this, "B- blood", Toast.LENGTH_SHORT).show()
        }
        else if (blood == "AB-"){
            disp_msge = "You can donate to AB blood groups patients only. But you can receive Blood from any other negative blood group persons."
            Toast.makeText(this, "AB- blood", Toast.LENGTH_SHORT).show()
        }

        val txt : TextView = findViewById(R.id.blood)
        txt.text = disp_msge

        val nbtn3 : Button = findViewById(R.id.nbtn3)
        nbtn3.setOnClickListener {
            val intent = Intent(this, fourth_activity::class.java).apply {
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