package com.dioageng.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class CustomList : AppCompatActivity() {

    val buah = arrayOf("Anggur", "Apel", "Belimbing", "Blueberry", "Jambu", "Jeruk")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)

        val listView: ListView = findViewById(R.id.mucustomlistview)

        // Set up the custom adapter with your array of fruits
        val adapter = CustomAdapter(this, buah)
        listView.adapter = adapter

        val goToHome = findViewById<CardView>(R.id.backtohome_customlistview)
        goToHome.setOnClickListener{
            val Intent = Intent(this, Home::class.java)
            startActivity(Intent)
        }
    }
}
