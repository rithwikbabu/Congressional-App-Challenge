package com.example.dietcentral.adapter5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dietcentral.R
import com.example.dietcentral.fragment_filter


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    companion object {
        var strings = mutableListOf<String>("Main Page")
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemCode: TextView = itemView.findViewById(R.id.tv1)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item4, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return strings.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        //viewHolder.setIsRecyclable(false);
        viewHolder.itemCode.text = strings[i]
    }
}

