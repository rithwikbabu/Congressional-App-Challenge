package com.example.dietcentral.adapter2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.dietcentral.R
import com.example.dietcentral.fragment_filter


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    companion object {
        var code1 = mutableListOf("Olive oil", "All purpose flour", "Butter", "Chicken", "Sugar", "Salt", "Egg", "Rice", "Vegetable oil", "Pork", "Beef", "Cheese", "Garlic", "Orange", "Turkey")
        var code2 = mutableListOf("Onion", "Corn", "Whole milk", "Mayonnaise", "Chiles", "Almonds", "Bacon", "Mushrooms", "Coconut", "Beets", "Strawberries", "Fennel", "Lamb", "Apple", "Shrimp")
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemCode: CheckBox = itemView.findViewById(R.id.checkBox)
        var itemCode2: CheckBox = itemView.findViewById(R.id.checkBox2)

        init {

        itemCode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                    fragment_filter.selectedChipData.add(buttonView.getText().toString())
                } else {
                    fragment_filter.selectedChipData.remove(buttonView.getText().toString())
            }
        }

            itemCode2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    fragment_filter.selectedChipData.add(buttonView.getText().toString())
                } else {
                    fragment_filter.selectedChipData.remove(buttonView.getText().toString())
                }
            }
        }
    }



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item2, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return code1.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemCode.text = code1[i]
        viewHolder.itemCode2.text = code2[i]
    }
}

