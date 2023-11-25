package com.dioageng.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class CustomList : AppCompatActivity() {

    val buah = arrayOf("Anggur", "Apel", "Belimbing", "Blueberry", "Jambu", "Jeruk")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)

        val goToHome = findViewById<CardView>(R.id.backtohome_customlistview)
        goToHome.setOnClickListener{
            val Intent = Intent(this, Home::class.java)
            startActivity(Intent)
        }
    }
}