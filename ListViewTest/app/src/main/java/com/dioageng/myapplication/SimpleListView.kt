package com.dioageng.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.cardview.widget.CardView

class SimpleListView : AppCompatActivity() {

    val buah = arrayOf("Anggur", "Apel", "Belimbing", "Blueberry", "Jambu", "Jeruk")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.mylistview)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, buah)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            // Get the selected fruit
            val selectedFruit = buah[position]

            // Get the resource ID of the image for the selected fruit
            val imageResourceId = resources.getIdentifier(selectedFruit.toLowerCase(), "drawable", packageName)

            // Get the description for the selected fruit
            val descriptionResourceId = resources.getIdentifier("${selectedFruit.toLowerCase()}_description", "string", packageName)
            val description = if (descriptionResourceId != 0) getString(descriptionResourceId) else ""

            // Launch Activity2 with the selected fruit, image, and description
            val intent = Intent(this, SimpleListView_activity1::class.java)
            intent.putExtra("buah", selectedFruit)
            intent.putExtra("imageResourceId", imageResourceId)
            intent.putExtra("description", description)
            startActivity(intent)
        }

        val goToHome = findViewById<CardView>(R.id.backtohome_simplelistview)
        goToHome.setOnClickListener{
            val Intent = Intent(this, Home::class.java)
            startActivity(Intent)
        }
    }
}
