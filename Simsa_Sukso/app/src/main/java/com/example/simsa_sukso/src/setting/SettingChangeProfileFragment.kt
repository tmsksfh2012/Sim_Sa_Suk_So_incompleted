package com.example.simsa_sukso.src.setting

import android.os.Bundle
import android.view.View
import com.example.simsa_sukso.R
import com.example.simsa_sukso.config.BaseFragment
import com.example.simsa_sukso.databinding.SettingChangeProfileFragmentBinding

class SettingChangeProfileFragment()
    :BaseFragment<SettingChangeProfileFragmentBinding>(SettingChangeProfileFragmentBinding::bind, R.layout.setting_change_profile_fragment){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.changeProfileBack.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, SettingFragment())
                .commitAllowingStateLoss()
        }
    }
}