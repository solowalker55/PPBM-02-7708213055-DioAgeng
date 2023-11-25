package com.dioageng.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class SimpleListView_activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the activity to run in immersive mode
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )

        // Hide the status bar
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

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

    override fun onBackPressed() {
        // Handle the back button press
        // For example, navigate to a certain activity
        val intent = Intent(this, SimpleListView::class.java)
        startActivity(intent)
    }
}
