package com.example.dietcentral

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dietcentral.R
import com.example.dietcentral.adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_diet_2.*
import kotlinx.android.synthetic.main.fragment_diet_7.*
import kotlinx.android.synthetic.main.fragment_settings.*

class fragment_settings : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val preferences_button = view.findViewById<Button>(R.id.preferences_button)
        val FragTan: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

        preferences_button?.setOnClickListener {
            PreferencesDialogFragment().show(FragTan, "dialog")
        }

        return view
    }
}