package com.example.dietcentral

import android.app.Dialog
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction


class HelpDialogFragment : DialogFragment() {

    /** The system calls this to get the DialogFragment's layout, regardless
    of whether it's being displayed as a dialog or an embedded fragment. */

    var mEditTextSubject: EditText? = null
    var mEditTextDescription: EditText? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout to use as dialog or embedded fragment
        var view = inflater.inflate(R.layout.settings_help, container, false)

        mEditTextSubject = view.findViewById(R.id.emailSubjText)
        mEditTextDescription = view.findViewById(R.id.emailDescText)
        val sendButton = view.findViewById<Button>(R.id.submit_button)

        val backbutton = view.findViewById<ImageButton>(R.id.backbutton_pref)
        val FragTan: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

        sendButton?.setOnClickListener {
            sendMail()
        }

        backbutton?.setOnClickListener {
            dismiss()
            FragTan.detach(fragment_settings())
            FragTan.attach(fragment_settings())
            FragTan.commit()
            FragTan.replace(R.id.fragment_container, fragment_settings());
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

    private fun sendMail() {
        var recipient = arrayOf("1diet.central@gmail.com")

        var subject = mEditTextSubject?.text.toString()
        var description = mEditTextDescription?.text.toString()

        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, recipient)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, description)

        intent.setType("message/rfc822")
        startActivity(Intent.createChooser(intent, "Choose an email client"))
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