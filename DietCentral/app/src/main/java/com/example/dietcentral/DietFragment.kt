package com.example.dietcentral

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dietcentral.adapter3.RecyclerAdapter
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.fragment_diet.*
import kotlinx.android.synthetic.main.fragment_diet_7.*
import com.opencsv.CSVReader
import java.io.IOException
import java.io.FileReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.BufferedReader
import java.nio.charset.Charset

class DietFragment : Fragment() {
    companion object{
        val imagList = mutableListOf<String>()
        val nameList = mutableListOf<String>()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =  inflater.inflate(R.layout.fragment_diet, container, false)
        InfoFragment.idvalue="0"
        val b1 = view?.findViewById<ImageButton>(R.id.button)
        val b2 = view?.findViewById<ImageButton>(R.id.clearButton)

        val FragTan: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

        b1?.setOnClickListener {
            fragment_filter.selectedDietData.clear()
            fragment_filter.selectedChipData.clear()
            FragTan.replace(R.id.fragment_container, fragment_filter());
            FragTan.commit()
        }

        val chipgroup = view.findViewById<ChipGroup>(R.id.dietChipGroup)



        var inputStream: InputStream = getResources().openRawResource(R.raw.dairy)
        var reader: BufferedReader = BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))

        fun updateChip(){
            chipgroup.removeAllViews()
            if (fragment_filter.selectedDietData.isNotEmpty()){
                val chip = Chip(chipgroup.context)
                chip.text = fragment_filter.selectedDietData[0]
                chipgroup.addView(chip)
                when (fragment_filter.selectedDietData[0]) {
                    "Keto" -> inputStream = getResources().openRawResource(R.raw.keto)
                    "Low-fat" -> inputStream = getResources().openRawResource(R.raw.lowfat)
                    "Low-carb" -> inputStream = getResources().openRawResource(R.raw.lowcarbs)
                    "Plant-based" -> inputStream = getResources().openRawResource(R.raw.plantbased)
                    "Paleo" -> inputStream = getResources().openRawResource(R.raw.paleo)
                    "Mediterranean" -> inputStream = getResources().openRawResource(R.raw.mediterranian)
                    "DASH" -> inputStream = getResources().openRawResource(R.raw.lowbloodpressure)
                    else -> {}
                }
                reader = BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))
                reader.readLine()
                while(true){
                    val nl = reader.readLine()
                    if(nl == null){
                        break
                    }
                    val token = nl.split(",")
                    imagList.add(token[token.size-1])
                    nameList.add(token[0])
                }

            }
            if (fragment_filter.selectedChipData.isNotEmpty()) {
                for (x in fragment_filter.selectedChipData) {
                    val chip = Chip(chipgroup.context)
                    chip.text = x
                    chipgroup.addView(chip)
                    when (x) {
                        "Vegan" -> inputStream = getResources().openRawResource(R.raw.vegan)
                        "Vegetarian" -> inputStream = getResources().openRawResource(R.raw.vegetarian)
                        "Gluten-Free" -> inputStream = getResources().openRawResource(R.raw.gluten)
                        "Seafood-Free" -> inputStream = getResources().openRawResource(R.raw.dairy)
                        "Dairy-Free" -> inputStream = getResources().openRawResource(R.raw.dairy)
                        "Soy-Free" -> inputStream = getResources().openRawResource(R.raw.soyfree)
                        "Peanut-Free" -> inputStream = getResources().openRawResource(R.raw.peanutfree)
                        "Wheat-Free" -> inputStream = getResources().openRawResource(R.raw.wheatfree)
                        else -> {}
                    }
                }
            }
            println(imagList)
            println(nameList)
        }

        updateChip()

        b2?.setOnClickListener {
            fragment_filter.selectedDietData.clear()
            fragment_filter.selectedChipData.clear()
            updateChip()
        }

        val mode = context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)
        when (mode) {
            Configuration.UI_MODE_NIGHT_YES -> {
                context?.let { ContextCompat.getColor(it, R.color.backgroundblack) }?.let { b1?.setBackgroundColor(it) }
                context?.let { ContextCompat.getColor(it, R.color.backgroundblack) }?.let { b2?.setBackgroundColor(it) }
            }
            Configuration.UI_MODE_NIGHT_NO -> {
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
            }
        }

        return view
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        dietsrcv.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = RecyclerAdapter()
        }
    }


}