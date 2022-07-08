package com.apoorav.clerror

import android.content.Intent
import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.apoorav.clerror.MainActivity as MainActivity1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fpage)

        val videoview : VideoView = findViewById(R.id.bgvdo)
        val uri : Uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.bgvdo)
        videoview.setVideoURI(uri)
        videoview.start()

        videoview.setOnPreparedListener(OnPreparedListener { mp -> mp.isLooping = true })

        fun onPause() {
            videoview.pause()
            super.onPause()
        }

        fun onResume() {
            videoview.resume()
            super.onResume()
        }
        fun onRestart() {
            videoview.start()
            super.onRestart()
        }
        fun onDestroy() {
            videoview.stopPlayback()
            super.onDestroy()
        }





        val marquetxt : TextView = findViewById(R.id.marqueetext)
        marquetxt.isSelected = true
        val lg_btn : Button = findViewById(R.id.lg_btn)
        lg_btn.setOnClickListener {
            Toast.makeText(this, "Visiting Next Page", Toast.LENGTH_LONG).show()
            val intent = Intent(this, detailsActivity::class.java).apply {  }
            startActivity(intent)
            finish()
        }
    }




}