package com.example.simsa_sukso.src.setting

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import androidx.core.content.ContextCompat
import com.example.simsa_sukso.R
import com.example.simsa_sukso.config.BaseFragment
import com.example.simsa_sukso.databinding.SettingAlertFragmentBinding
import com.example.simsa_sukso.src.utils.Constants.TAG

class SettingAlertFragment()
    :BaseFragment<SettingAlertFragmentBinding>(SettingAlertFragmentBinding::bind, R.layout.setting_alert_fragment){

    private var cnt:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dSettingAlertBack = SettingAlertBackDialog()

        binding.alertBack.setOnClickListener {
            dSettingAlertBack.show(childFragmentManager, dSettingAlertBack.tag)
        }

        binding.pushSwitch.setOnCheckedChangeListener{ compoundButton: CompoundButton, isChecked: Boolean ->
            if(isChecked) {
                if (cnt == 0){
                    binding.alertChk.setTextColor(ContextCompat.getColor(context!!, R.color.main_color))
                }
                cnt++
            }
            else {
                if(cnt == 1){
                    binding.alertChk.setTextColor(ContextCompat.getColor(context!!, R.color.gray))
                }
                cnt--
            }
        }
        binding.stopSwitch.setOnCheckedChangeListener{ compoundButton: CompoundButton, isChecked: Boolean ->
            if(isChecked) {
                if (cnt == 0){
                    binding.alertChk.setTextColor(ContextCompat.getColor(context!!, R.color.main_color))
                }
                cnt++
            }
            else {
                if(cnt == 1){
                    binding.alertChk.setTextColor(ContextCompat.getColor(context!!, R.color.gray))
                }
                cnt--
            }
        }
        binding.mySwitch.setOnCheckedChangeListener{ compoundButton: CompoundButton, isChecked: Boolean ->
            if(isChecked) {
                if (cnt == 0){
                    binding.alertChk.setTextColor(ContextCompat.getColor(context!!, R.color.main_color))
                }
                cnt++
            }
            else {
                if(cnt == 1){
                    binding.alertChk.setTextColor(ContextCompat.getColor(context!!, R.color.gray))
                }
                cnt--
            }
        }

        binding.alertChk.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, SettingFragment())
                .commitAllowingStateLoss()
        }
    }
}