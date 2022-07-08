package com.apoorav.clerror

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class final_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.final_page)

        val spotify : Button = findViewById(R.id.spotify)
        val insta : Button = findViewById(R.id.insta)
        val linkedin : Button = findViewById(R.id.linkedin)
        val gmail : Button = findViewById(R.id.gmail)

        val sUri : Uri = Uri.parse("https://open.spotify.com/user/cruyg8b499xaq0l7htbh6tyhm?si=8cb699387a7c419b")
        val iUri : Uri = Uri.parse("https://instagram.com/apooravkumar.29?igshid=YmMyMTA2M2Y=")
        val lUri : Uri = Uri.parse("https://linkedin.com/in/apoorav-kumar-aa5162219")
        val mUri : Uri = Uri.parse("mailto:apooravkumar.29@gmail.com")

        spotify.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, sUri)
            Toast.makeText(this, "Opening Spotify...", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

         insta.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, iUri)
             Toast.makeText(this, "Opening Instagram...", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

         linkedin.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, lUri)
             Toast.makeText(this, "Opening LinkedIn...", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

         gmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, mUri)
             Toast.makeText(this, "Opening Mail Service...", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }


    }
}