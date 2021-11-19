package com.example.simsa_sukso.src.setting

import android.os.Bundle
import android.view.View
import com.example.simsa_sukso.R
import com.example.simsa_sukso.config.BaseFragment
import com.example.simsa_sukso.databinding.SettingFragmentBinding
import com.example.simsa_sukso.src.setting.my_feed.SettingMyFeedFragment

class SettingFragment()
    :BaseFragment<SettingFragmentBinding>(SettingFragmentBinding::bind, R.layout.setting_fragment){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myFeed.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, SettingMyFeedFragment())
                .commitAllowingStateLoss()
        }
        binding.alert.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, SettingAlertFragment())
                .commitAllowingStateLoss()
        }
        binding.changeProfile.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, SettingChangeProfileFragment())
                .commitAllowingStateLoss()
        }
        binding.logout.setOnClickListener {  }
        binding.deleteAccount.setOnClickListener {  }
    }
}