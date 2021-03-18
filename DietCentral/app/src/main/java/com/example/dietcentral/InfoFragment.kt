package com.example.dietcentral

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class InfoFragment : Fragment() {
    companion object {
        var idvalue = "initial value"
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =  inflater.inflate(R.layout.fragment_info, container, false)


        val b1 = view?.findViewById<Button>(R.id.intermittent_fasting_button)
        val b2 = view?.findViewById<Button>(R.id.plant_based_diets)
        val b3 = view?.findViewById<Button>(R.id.low_carb_diets)
        val b4 = view?.findViewById<Button>(R.id.the_mediterranean_diet)
        val b5 = view?.findViewById<Button>(R.id.low_fat_diets)
        val b6 = view?.findViewById<Button>(R.id.the_paleo_diet)
        val b7 = view?.findViewById<Button>(R.id.the_DASH_diet)
        val b8 = view?.findViewById<Button>(R.id.the_keto_diet)

        val FragTan: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

        b1?.setOnClickListener {
            idvalue = "1"
            FragTan.replace(R.id.fragment_container, diet_1());
            FragTan.commit()
        }

        b2?.setOnClickListener {
            idvalue = "2"
            FragTan.replace(R.id.fragment_container, diet_2());
            FragTan.commit()
        }

        b3?.setOnClickListener {
            idvalue = "3"
            FragTan.replace(R.id.fragment_container, diet_3());
            FragTan.commit()
        }

        b4?.setOnClickListener {
            idvalue = "4"
            FragTan.replace(R.id.fragment_container, diet_4());
            FragTan.commit()
        }

        b5?.setOnClickListener {
            idvalue = "5"
            FragTan.replace(R.id.fragment_container, diet_5());
            FragTan.commit()
        }

        b6?.setOnClickListener {
            idvalue = "6"
            FragTan.replace(R.id.fragment_container, diet_6());
            FragTan.commit()
        }

        b7?.setOnClickListener {
            idvalue = "7"
            FragTan.replace(R.id.fragment_container, diet_7());
            FragTan.commit()
        }

        b8?.setOnClickListener {
            idvalue = "8"
            FragTan.replace(R.id.fragment_container, diet_8());
            FragTan.commit()
        }

        return view

    }


}