package com.dioageng.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class SimpleListView_activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acitivity2)

        val textView: TextView = findViewById(R.id.textview_selectedItem)
        val imageView: ImageView = findViewById(R.id.fruit_bg)
        val descriptionTextView: TextView = findViewById(R.id.fruit_description)

        // Get the selected fruit, image, and description from the intent
        val selectedFruit = intent.getStringExtra("buah")
        val imageResourceId = intent.getIntExtra("imageResourceId", 0)
        val description = intent.getStringExtra("description")

        // Display the selected fruit, image, and description in respective views
        textView.text = selectedFruit
        imageView.setImageResource(imageResourceId)
        descriptionTextView.text = description

        val goTosimplelistview = findViewById<CardView>(R.id.backtohome_simplelistview_activity1)
        goTosimplelistview.setOnClickListener{
            val Intent = Intent(this, SimpleListView::class.java)
            startActivity(Intent)
        }
    }
}
