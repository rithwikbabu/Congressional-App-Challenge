package com.example.dietcentral

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
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
        val info_button = view.findViewById<Button>(R.id.more_info_button)
        val help_button = view.findViewById<Button>(R.id.help_button)
        val toc_button = view.findViewById<Button>(R.id.toc_button)

        val mode = context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)
        when (mode) {
            Configuration.UI_MODE_NIGHT_YES -> {preferences_button.setBackgroundColor(Color.DKGRAY); info_button.setBackgroundColor(Color.DKGRAY);
                help_button.setBackgroundColor(Color.DKGRAY); toc_button.setBackgroundColor(Color.DKGRAY)
                                                preferences_button.setTextColor(Color.WHITE); info_button.setTextColor(Color.WHITE);
                help_button.setTextColor(Color.WHITE); toc_button.setTextColor(Color.WHITE)
            }
            Configuration.UI_MODE_NIGHT_NO -> {}
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {}
        }


        val FragTan: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()


        preferences_button?.setOnClickListener {
            FragTan.add(PreferencesDialogFragment(), "dialog");
            FragTan.commitAllowingStateLoss();
        }

        info_button?.setOnClickListener {
            FragTan.add(InfoDialogFragment(), "dialog");
            FragTan.commitAllowingStateLoss();
        }

        help_button?.setOnClickListener {
            FragTan.add(HelpDialogFragment(), "dialog");
            FragTan.commitAllowingStateLoss();
        }

        toc_button?.setOnClickListener {
            FragTan.add(TocDialogFragment(), "dialog");
            FragTan.commitAllowingStateLoss();
        }

        return view
    }
}