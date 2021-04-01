package com.example.dietcentral

import android.app.Dialog
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction


class InfoDialogFragment : DialogFragment() {

    /** The system calls this to get the DialogFragment's layout, regardless
    of whether it's being displayed as a dialog or an embedded fragment. */
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout to use as dialog or embedded fragment
        var view = inflater.inflate(R.layout.settings_info, container, false)

        val backbutton = view.findViewById<ImageButton>(R.id.backbutton_pref)
        val FragTan: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

        backbutton?.setOnClickListener {
            dismiss()
            FragTan.detach(fragment_settings())
            FragTan.attach(fragment_settings())
            FragTan.commit()
            FragTan.replace(R.id.fragment_container, fragment_settings());
        }

        val fbicon = view.findViewById<ImageView>(R.id.fbicon)
        val inicon = view.findViewById<ImageView>(R.id.inicon)
        val igicon = view.findViewById<ImageView>(R.id.igicon)
        val twicon = view.findViewById<ImageView>(R.id.twicon)

        fbicon?.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"))
            startActivity(browserIntent)
        }

        inicon?.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/"))
            startActivity(browserIntent)
        }

        igicon?.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/dietcentralapp/?hl=en"))
            startActivity(browserIntent)
        }

        twicon?.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"))
            startActivity(browserIntent)
        }


        val mode = context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)
        when (mode) {
            Configuration.UI_MODE_NIGHT_YES -> { backbutton.setColorFilter(Color.WHITE)
            }
            Configuration.UI_MODE_NIGHT_NO -> {}
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {}
        }

        return view
    }

    /** The system calls this only when creating the layout in a dialog. */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // The only reason you might override this method when using onCreateView() is
        // to modify any dialog characteristics. For example, the dialog includes a
        // title by default, but your custom layout might not need it. So here you can
        // remove the dialog title, but you must call the superclass to get the Dialog.
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }
}