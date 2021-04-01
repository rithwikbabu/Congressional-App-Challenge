package com.example.dietcentral

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment


class fragment_timer : Fragment() {

    var i = -1
    var mProgressBar: ProgressBar? = null
    var mProgressBar1:ProgressBar? = null

    private var buttonStartTime: Button? = null
    private var buttonStopTime:Button? = null
    private var edtTimerValue: EditText? = null
    private var textViewShowTime: TextView? = null
    private var countDownTimer: CountDownTimer? = null
    private var totalTimeCountInMilliseconds: Long = 0

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_timer, container, false)


        buttonStartTime = view.findViewById<Button>(R.id.button_timerview_start);
        buttonStopTime = view.findViewById<Button>(R.id.button_timerview_stop);

        textViewShowTime = view.findViewById<TextView>(R.id.textView_timerview_time);
        edtTimerValue = view.findViewById<EditText>(R.id.textview_timerview_back);

        mProgressBar = view.findViewById<ProgressBar>(R.id.progressbar_timerview);
        mProgressBar1 = view.findViewById<ProgressBar>(R.id.progressbar1_timerview);

        buttonStartTime?.setOnClickListener {
            setTimer()
            buttonStartTime!!.visibility = View.INVISIBLE
            buttonStopTime!!.visibility = View.VISIBLE
            mProgressBar!!.visibility = View.INVISIBLE
            startTimer()
            mProgressBar1!!.visibility = View.VISIBLE
        }
        buttonStopTime?.setOnClickListener {
            countDownTimer!!.cancel()
            countDownTimer!!.onFinish()
            mProgressBar1!!.visibility = View.GONE
            mProgressBar!!.visibility = View.VISIBLE
            edtTimerValue!!.visibility = View.VISIBLE
            buttonStartTime!!.visibility = View.VISIBLE
            buttonStopTime!!.visibility = View.INVISIBLE
        }

        return view
    }

    private fun setTimer() {
        var time = 0
        if (edtTimerValue!!.text.toString() != "") {
            time = edtTimerValue!!.text.toString().toInt()
        }
        totalTimeCountInMilliseconds = time * 1000.toLong()
        mProgressBar1!!.max = time * 1000
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(totalTimeCountInMilliseconds, 1) {
            override fun onTick(leftTimeInMilliseconds: Long) {
                val seconds = leftTimeInMilliseconds / 1000
                mProgressBar1!!.progress = leftTimeInMilliseconds.toInt()
                textViewShowTime!!.text = String.format("%02d", seconds / 60) + ":" + String.format("%02d", seconds % 60)
            }

            override fun onFinish() {
                textViewShowTime!!.text = "00:00"
                textViewShowTime!!.visibility = View.VISIBLE
                buttonStartTime!!.visibility = View.VISIBLE
                buttonStopTime!!.visibility = View.VISIBLE
                mProgressBar!!.visibility = View.VISIBLE
                mProgressBar1!!.visibility = View.GONE
            }
        }.start()
    }
}