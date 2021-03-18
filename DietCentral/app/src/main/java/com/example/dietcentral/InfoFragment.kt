package com.example.dietcentral

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class InfoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =  inflater.inflate(R.layout.fragment_info, container, false)

        val thirdFragment=DietFragment()

        val b1 = view?.findViewById<Button>(R.id.plant_based_diets)

        val InfoFragment = InfoFragment()
        val diet_1 = diet_1()
        val FragTan: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

        b1?.setOnClickListener {
            //setCurrentFragment(thirdFragment)
            FragTan.replace(R.id.fragment_container, diet_1);
            FragTan.commit()
        }
        return view

    }

//    private fun setCurrentFragment(fragment:Fragment)=
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.fragment_container,fragment)
//                commit()
//            }


}