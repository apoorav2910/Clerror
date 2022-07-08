package com.apoorav.clerror

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class first_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_page)
        //val fname : TextInputEditText? = null
        val tm_btn : Button? = findViewById(R.id.tm_btn)
//        val fname: TextInputEditText = findViewById(R.id.fname)
//        val ftext: String = fname.text.toString()
        val wlcm: TextView = findViewById(R.id.wlcm)
        val a = intent.extras?.getString("fname")
        val b = intent.extras?.getString("lname")
        val disp_msg = "Welcome to my App ${a?.uppercase()} ${b?.uppercase()}. I am glad that you are trying this app. It is way too basic but I am still at my learning stage of Android development. I am currently pursuing BE-CSE from Chandigarh University. I have just completed my First Year."
        wlcm.text = ("$disp_msg").toString()
        val fimg : ImageView = findViewById(R.id.fimg)

        val img = Intent(this, detailsActivity::class.java)
            img.putExtra("img", R.id.fimg)


        val gender = intent.extras?.getString("gender")

        val sday = intent.extras?.getInt("sday")
        val smonth = intent.extras?.getInt("smonth")
        val syear = intent.extras?.getInt("syear")
        val age = intent.extras?.getString("age")
        val blood = intent.extras?.getString("blood")
        val weight = intent.extras?.getString("weight")
        val height = intent.extras?.getInt("height")

//        if (gender == 102 || gender == 70) {
//            Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show()
//            fimg.setImageResource(R.drawable.female) //setImageURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.drawable.female))
//            //fimg.setImageState()
//        }
        val spage = Intent(this, sec_page::class.java).apply {
            putExtra("fname", a)
            putExtra("lname", b)
            putExtra("sday", sday)
            putExtra("smonth", smonth)
            putExtra("syear", syear)
            putExtra("age", age)
            putExtra("gender", gender)
            putExtra("blood", blood)
            putExtra("weight", weight)
            putExtra("height", height)
        }
        val nbtn1 : Button = findViewById(R.id.nbtn1)
        nbtn1.setOnClickListener {
            startActivity(spage)
            finish()
        }
    }
}