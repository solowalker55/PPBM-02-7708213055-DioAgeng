package com.dioageng.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class CustomList : AppCompatActivity() {

    val buah = arrayOf("Anggur", "Apel", "Belimbing", "Blueberry", "Jambu", "Jeruk")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)

        val listView: ListView = findViewById(R.id.mucustomlistview)

        // Set up the adapter with your array of fruits
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, buah)
        listView.adapter = adapter

        // Set item click listener
        listView.setOnItemClickListener { _, _, position, _ ->
            // Get the selected fruit
            val selectedFruit = buah[position]

            // Launch CustomListView_activity1 with the selected fruit
            val intent = Intent(this, CustomListView_activity1::class.java)
            intent.putExtra("fruit_name", selectedFruit)
            startActivity(intent)
        }

        val goToHome = findViewById<CardView>(R.id.backtohome_customlistview)
        goToHome.setOnClickListener{
            val Intent = Intent(this, Home::class.java)
            startActivity(Intent)
        }
    }
}
