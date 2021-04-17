package com.example.dietcentral.adapter3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dietcentral.R
import com.example.dietcentral.diet_1
import com.example.dietcentral.fragment_filter


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    companion object {
        var lbname = mutableListOf("1","3","5","7","9")
        var rbname = mutableListOf("2","4","6","8","10")
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var leftbutton: Button = itemView.findViewById(R.id.leftbutton)
        var rightbutton: Button = itemView.findViewById(R.id.rightbutton)
        var leftimage: ImageButton = itemView.findViewById(R.id.leftimage)
        var rightimage: ImageButton = itemView.findViewById(R.id.rightimage)

        init {

            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context
                var intent = Intent(context, diet_1::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("lefttext", leftbutton.text)
                    putExtra("leftimage", leftimage.imageAlpha)
                    putExtra("righttext", rightbutton.text)
                    putExtra("rightimage", rightimage.imageAlpha)
                }
                context.startActivity(intent)
            }
        }
    }



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item3, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return lbname.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        //viewHolder.setIsRecyclable(false);
        viewHolder.leftbutton.text = lbname[i]
        viewHolder.rightbutton.text = rbname[i]
    }
}

