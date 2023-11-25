package com.dioageng.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class Home : AppCompatActivity() {
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

        // Set the content view after setting up immersive mode
        setContentView(R.layout.activity_home)

        val goToSimpleListView = findViewById<CardView>(R.id.gotosimplelist)
        goToSimpleListView.setOnClickListener{
            val Intent = Intent(this, SimpleListView::class.java)
            startActivity(Intent)
        }

        val goToCustomListView = findViewById<CardView>(R.id.gotocustomlist)
        goToCustomListView.setOnClickListener{
            val Intent = Intent(this, CustomList::class.java)
            startActivity(Intent)
        }
    }
}
