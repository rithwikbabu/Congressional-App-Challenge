package com.example.dietcentral

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.fragment_diet.*
import org.jetbrains.anko.find
import org.w3c.dom.Text


class fragment_filter : Fragment(){

    var btnApply = null
    var selectedChipData = mutableListOf<String>("")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_filter, container, false)

        var chipfast = view.findViewById<Chip>(R.id.fastingchip)
        var chipketo = view.findViewById<Chip>(R.id.ketochip)
        var chipcarb = view.findViewById<Chip>(R.id.lowcarbchip)
        var chipfat = view.findViewById<Chip>(R.id.lowfatchip)
        var chippaleo = view.findViewById<Chip>(R.id.paleochip)
        var chipmedit = view.findViewById<Chip>(R.id.mediterraneanchip)
        var chipdash = view.findViewById<Chip>(R.id.dashchip)
        var chipplant = view.findViewById<Chip>(R.id.plantbasedchip)

        var chipvegan = view.findViewById<Chip>(R.id.Vegan)
        var chipvegetarian = view.findViewById<Chip>(R.id.Vegetarian)
        var chipgluten = view.findViewById<Chip>(R.id.Gluten)
        var chipwheat = view.findViewById<Chip>(R.id.Wheat)
        var chipsoy = view.findViewById<Chip>(R.id.Soy)
        var chipdairy = view.findViewById<Chip>(R.id.Dairy)
        var chippeanut = view.findViewById<Chip>(R.id.Peanut)
        var chipseafood = view.findViewById<Chip>(R.id.Seafood)

        var chipgroup1 = view.findViewById<ChipGroup>(R.id.chipGroup1)
        var chipgroup2 = view.findViewById<ChipGroup>(R.id.chipGroup2)

        var textview1 = view.findViewById<TextView>(R.id.textView11)


        val checkedChangeListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selectedChipData.add(buttonView.getText().toString())
                textview1.setText("It works")
            } else {
                selectedChipData.remove(buttonView.getText().toString())
            }
        }

        chipfast.setOnCheckedChangeListener(checkedChangeListener)
        chipketo.setOnCheckedChangeListener(checkedChangeListener)
        chipcarb.setOnCheckedChangeListener(checkedChangeListener)
        chipfat.setOnCheckedChangeListener(checkedChangeListener)
        chippaleo.setOnCheckedChangeListener(checkedChangeListener)
        chipmedit.setOnCheckedChangeListener(checkedChangeListener)
        chipdash.setOnCheckedChangeListener(checkedChangeListener)
        chipplant.setOnCheckedChangeListener(checkedChangeListener)

        return view
    }


}