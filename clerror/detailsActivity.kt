package com.apoorav.clerror

import android.app.DatePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*


class detailsActivity : AppCompatActivity(){
    //private var dob_btn:TextView? = null
    private var syear1 : Int = 0
    private var smonth1 : Int = 0
    private var sday1 : Int = 0
    private var age1 : String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.name_page)

        val tm_btn : Button = findViewById(R.id.tm_btn)
        //val fimg : ImageView = findViewById(R.id.fimg)
        tm_btn.setOnClickListener {
            val ftext : TextInputEditText = findViewById(R.id.fname)
            val a = ftext.text.toString()

            val dob_btn : Button = findViewById(R.id.dob_btn)
            val lntext : TextInputEditText = findViewById(R.id.lname)
            val gender : TextInputEditText = findViewById(R.id.gender)
            val blood : TextInputEditText = findViewById(R.id.bgrp)
            val weight : TextInputEditText = findViewById(R.id.weight)
            val height : TextInputEditText = findViewById(R.id.height)
            //val heightinM : Double = height.text.toString().toDouble()/100.00

            if( (ftext.text.toString()).isEmpty()) {
                Toast.makeText(this, "Please fill First Name", Toast.LENGTH_LONG).show()
                ftext.setError("First name is required!")
            }
            else if( (lntext.text.toString()).isEmpty()) {
                Toast.makeText(this, "Please fill Last Name", Toast.LENGTH_LONG).show()
                lntext.setError("Last name is required!")
            }
            else if( (gender.text.toString()).isEmpty()) {
                Toast.makeText(this, "Please fill Gender", Toast.LENGTH_LONG).show()
                gender.setError("Gender is required!")
            }
            else if( (dob_btn.text.toString()).isEmpty()) {
                Toast.makeText(this, "Please select date", Toast.LENGTH_LONG).show()
                dob_btn.setError("Date is required!")
            }
            else if( (blood.text.toString()).isEmpty()) {
                Toast.makeText(this, "Please fill Blood Group", Toast.LENGTH_LONG).show()
                blood.setError("Blood Group is required!")
            }
            else if( (weight.text.toString()).isEmpty()) {
                Toast.makeText(this, "Please fill Weight", Toast.LENGTH_LONG).show()
                weight.setError("Weight is required!")
            }
            else if( (height.text.toString()).isEmpty()) {
                Toast.makeText(this, "Please fill Height", Toast.LENGTH_LONG).show()
                height.setError("Height is required!")
            }
            else {
                val tm_intent = Intent(this, first_page::class.java).apply {
                    putExtra("fname", a)
                    putExtra("lname", lntext.text.toString())
                    putExtra("gender", gender.text.toString())
                    putExtra("syear", syear1)
                    putExtra("smonth", smonth1)
                    putExtra("sday", sday1)
                    putExtra("age", age1)
                    putExtra("blood", blood.text.toString())
                    putExtra("weight", weight.text.toString())
                    putExtra("height", height.text.toString().toInt())
                }

                // val fimg : ImageView = findViewById(R.id.fimg)

                startActivity(tm_intent)
            }

        }

    }
    fun dateBtn(view : View) {
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        Toast.makeText(this, "Select Date", Toast.LENGTH_SHORT).show()

        val dob = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { view, syear, smonth, sdayOfMonth ->

                syear1 = syear.toInt()
                smonth1 = smonth.toInt()
                sday1 = sdayOfMonth.toInt()

                val selectedDate = "$sdayOfMonth/${smonth + 1}/$syear"
                val dobBtn : TextView = findViewById(R.id.dob_btn)
                dobBtn.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val thedate = sdf.parse(selectedDate)
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentdateinM = currentDate

                var age : String? = null
                if (month - smonth == 0){
                val ageInYear = "${(year)-syear}"
                age = "${ageInYear} years"
                }
                else if (month - smonth<=0){
                    val ageInYear = "${(year-1)-syear}"
                    age = "$ageInYear years & ${(12 - smonth) + month} months"
                }
                else if (month - smonth >= 0){
                    val ageInYear = "${(year)-syear}"
                    age = "${ageInYear} years & ${(month - smonth)} months"
                }
                else { age = "Unexpected Error Occurred" }
                age1 = age.toString()

            },
            year, month, day
        )
        dob.show()
         //dob.get
    }


}

