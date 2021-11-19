package com.example.simsa_sukso.src.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.simsa_sukso.R

class SettingAlertBackDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?)
    : View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.setting_alert_back_dialog, container, false)
        isCancelable = false

        return view.rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.apply {
            findViewById<TextView>(R.id.alert_back_NO).setOnClickListener {
                dismiss()
            }
            findViewById<TextView>(R.id.alert_back_YES).setOnClickListener {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, SettingFragment())
                    .commitAllowingStateLoss()
            }
        }
    }
}