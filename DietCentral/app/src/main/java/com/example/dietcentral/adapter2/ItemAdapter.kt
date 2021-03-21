package com.example.dietcentral.adapter2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dietcentral.InfoFragment
import com.example.dietcentral.R
import com.example.dietcentral.diet_1
import com.example.dietcentral.fragment_filter

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    companion object {
        var code = mutableListOf("Olive oil", "All purpose flour", "Butter", "Chicken", "Sugar", "Salt", "Egg", "Rice", "Vegetable oil", "Pork", "Beef", "Cheese", "Garlic", "Orange", "Turkey", "Onion", "Corn", "Whole milk", "Mayonnaise", "Chiles", "Almonds", "Bacon", "Mushrooms", "Coconut", "Beets", "Strawberries", "Fennel", "Lamb", "Apple", "Shrimp")
        var tempcode = code
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemCode: TextView

        init {
            itemCode = itemView.findViewById(R.id.checkBox)

            itemView.setOnClickListener {
                val position: Int = getAdapterPosition()
                val context = itemView.context
                val intent = Intent(context, fragment_filter::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("CODE", itemCode.text)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item2, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return code.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemCode.text = code[i]
    }
}

