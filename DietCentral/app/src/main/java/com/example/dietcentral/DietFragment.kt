package com.example.dietcentral

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class DietFragment : Fragment() {
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

        fun updateChip(){
            chipgroup.removeAllViews()
            if (fragment_filter.selectedDietData.isNotEmpty()){
                val chip = Chip(chipgroup.context)
                chip.text = fragment_filter.selectedDietData[0]
                chipgroup.addView(chip)
            }
            if (fragment_filter.selectedChipData.isNotEmpty()) {
                for (x in fragment_filter.selectedChipData) {
                    val chip = Chip(chipgroup.context)
                    chip.text = x
                    chipgroup.addView(chip)
                }
            }
        }

        updateChip()

        b2?.setOnClickListener {
            fragment_filter.selectedDietData.clear()
            fragment_filter.selectedChipData.clear()
            updateChip()
        }

        return view
    }


}