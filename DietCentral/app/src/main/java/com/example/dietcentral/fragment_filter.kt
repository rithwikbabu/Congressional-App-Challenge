package com.example.dietcentral

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dietcentral.adapter2.RecyclerAdapter
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.fragment_filter.*


class fragment_filter : Fragment(){
    companion object{
        var selectedChipData = mutableListOf<String>()
        var selectedDietData = mutableListOf<String>()
    }

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_filter, container, false)
        val view2 = inflater.inflate(R.layout.fragment_diet, container, false)

        val b1 = view?.findViewById<Button>(R.id.backbutton)

        val FragTan: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

        var chipgroup1 = view.findViewById<ChipGroup>(R.id.chipGroup1)
        var chipgroup2 = view.findViewById<ChipGroup>(R.id.chipGroup2)
        val chipgroup3 = view.findViewById<ChipGroup>(R.id.chipGroup3)
        val chipgroup4 = view2.findViewById<ChipGroup>(R.id.dietChipGroup)

        fun updateChip(){
            chipgroup3.removeAllViews()
            if (selectedDietData.isNotEmpty()){
                val chip = Chip(chipgroup3.context); val chip2 = Chip(chipgroup4.context)
                chip.text = selectedDietData[0]; chip2.text = selectedDietData[0]
                chipgroup3.addView(chip); chipgroup4.addView(chip2)
            }
            if (selectedChipData.isNotEmpty()) {
                for (x in selectedChipData) {
                    val chip = Chip(chipgroup3.context); val chip2 = Chip(chipgroup3.context)
                    chip.text = x; chip2.text = x
                    chipgroup3.addView(chip); chipgroup4.addView(chip2)
                }
            }
        }

        updateChip()

        val checkedChangeListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selectedChipData.add(buttonView.getText().toString())
                updateChip()
            } else {
                selectedChipData.remove(buttonView.getText().toString())
                updateChip()
            }
        }

        val dietCheckedChangeListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selectedDietData.add(buttonView.getText().toString())
                updateChip()
            } else {
                if(selectedDietData.isNotEmpty()){
                    selectedDietData.remove(buttonView.getText().toString())
                    updateChip()
                }
            }
        }

        var chipfast = view.findViewById<Chip>(R.id.fastingchip); chipfast.setOnCheckedChangeListener(dietCheckedChangeListener)
        var chipketo = view.findViewById<Chip>(R.id.ketochip); chipketo.setOnCheckedChangeListener(dietCheckedChangeListener)
        var chipcarb = view.findViewById<Chip>(R.id.lowcarbchip); chipcarb.setOnCheckedChangeListener(dietCheckedChangeListener)
        var chipfat = view.findViewById<Chip>(R.id.lowfatchip); chipfat.setOnCheckedChangeListener(dietCheckedChangeListener)
        var chippaleo = view.findViewById<Chip>(R.id.paleochip); chippaleo.setOnCheckedChangeListener(dietCheckedChangeListener)
        var chipmedit = view.findViewById<Chip>(R.id.mediterraneanchip); chipmedit.setOnCheckedChangeListener(dietCheckedChangeListener)
        var chipdash = view.findViewById<Chip>(R.id.dashchip); chipdash.setOnCheckedChangeListener(dietCheckedChangeListener)
        var chipplant = view.findViewById<Chip>(R.id.plantbasedchip); chipplant.setOnCheckedChangeListener(dietCheckedChangeListener)

        var chipvegan = view.findViewById<Chip>(R.id.Vegan); chipvegan.setOnCheckedChangeListener(checkedChangeListener)
        var chipvegetarian = view.findViewById<Chip>(R.id.Vegetarian); chipvegetarian.setOnCheckedChangeListener(checkedChangeListener)
        var chipgluten = view.findViewById<Chip>(R.id.Gluten); chipgluten.setOnCheckedChangeListener(checkedChangeListener)
        var chipwheat = view.findViewById<Chip>(R.id.Wheat); chipwheat.setOnCheckedChangeListener(checkedChangeListener)
        var chipsoy = view.findViewById<Chip>(R.id.Soy); chipsoy.setOnCheckedChangeListener(checkedChangeListener)
        var chipdairy = view.findViewById<Chip>(R.id.Dairy); chipdairy.setOnCheckedChangeListener(checkedChangeListener)
        var chippeanut = view.findViewById<Chip>(R.id.Peanut); chippeanut.setOnCheckedChangeListener(checkedChangeListener)
        var chipseafood = view.findViewById<Chip>(R.id.Seafood); chipseafood.setOnCheckedChangeListener(checkedChangeListener)

        b1?.setOnClickListener {
            FragTan.replace(R.id.fragment_container, DietFragment());
            updateChip()
            FragTan.commit()
        }

        val tv11 = view.findViewById<TextView>(R.id.textView11)
        val ingredients = mutableListOf<String>()
        ingredients.addAll(RecyclerAdapter.code)
        view.findViewById<SearchView>(R.id.searchView1)?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                RecyclerAdapter.code.clear()
                adapter?.notifyItemRangeRemoved(0, 29)

                if(ingredients.contains(query)){
                    if (query != null) {
                        RecyclerAdapter.code.add(query)
                        adapter?.notifyItemInserted(0)
                        tv11.text = query
                    }
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        return view

    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        result_recycleview.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = com.example.dietcentral.adapter2.RecyclerAdapter()
        }
    }



}