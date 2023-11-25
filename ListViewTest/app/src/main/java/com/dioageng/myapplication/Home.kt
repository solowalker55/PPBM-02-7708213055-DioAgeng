package com.dioageng.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.cardview.widget.CardView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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