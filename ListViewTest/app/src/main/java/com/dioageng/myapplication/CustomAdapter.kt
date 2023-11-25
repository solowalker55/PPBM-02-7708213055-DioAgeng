package com.dioageng.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class CustomAdapter(private val context: Context, private val fruits: Array<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return fruits.size
    }

    override fun getItem(position: Int): Any {
        return fruits[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.custom_list_item, parent, false)

        val cardView: CardView = view.findViewById(R.id.cardView)
        val fruitNameTextView: TextView = view.findViewById(R.id.fruit_name)
        val fruitBackgroundImageView: ImageView = view.findViewById(R.id.fruit_background)

        val fruit = getItem(position) as String
        fruitNameTextView.text = fruit

        // Set the background image based on the fruit
        val imageResId = context.resources.getIdentifier(
            fruit.toLowerCase(),
            "drawable",
            context.packageName
        )
        if (imageResId != 0) {
            fruitBackgroundImageView.setImageResource(imageResId)
        }

        // Set item click listener
        cardView.setOnClickListener {
            // Launch CustomListView_activity1 with the selected fruit
            val intent = Intent(context, CustomListView_activity1::class.java)
            intent.putExtra("fruit_name", fruit)
            context.startActivity(intent)
        }

        return view
    }
}
