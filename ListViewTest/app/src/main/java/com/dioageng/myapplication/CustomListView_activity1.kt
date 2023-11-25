package com.dioageng.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class CustomListView_activity1 : AppCompatActivity() {

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

        setContentView(R.layout.activity_custom_list_view1)

        // Get the selected fruit name from the intent
        val selectedFruit: String? = intent.getStringExtra("fruit_name")

        // Check if selectedFruit is not null before using it
        if (selectedFruit != null) {
            // Set the title (fruit name) in the TextView
            val titleTextView: TextView = findViewById(R.id.textview_selectedItem)
            titleTextView.text = selectedFruit

            // Set the description in the TextView based on the selected fruit
            val descriptionTextView: TextView = findViewById(R.id.fruit_description)
            val descriptionResId = resources.getIdentifier(
                "${selectedFruit.toLowerCase()}_description",
                "string",
                packageName
            )
            // Check if descriptionResId is not 0 before getting the string
            if (descriptionResId != 0) {
                descriptionTextView.text = getString(descriptionResId)
            }

            // Set the image based on the selected fruit
            val imageView: ImageView = findViewById(R.id.fruit_bg)
            val imageResId = resources.getIdentifier(
                selectedFruit.toLowerCase(),
                "drawable",
                packageName
            )
            // Check if imageResId is not 0 before setting the image
            if (imageResId != 0) {
                imageView.setImageResource(imageResId)
            }
        }

        val goToCustomListView = findViewById<CardView>(R.id.backtolist_customlistview_activity1)
        goToCustomListView.setOnClickListener{
            val Intent = Intent(this, CustomList::class.java)
            startActivity(Intent)
        }
    }
}
