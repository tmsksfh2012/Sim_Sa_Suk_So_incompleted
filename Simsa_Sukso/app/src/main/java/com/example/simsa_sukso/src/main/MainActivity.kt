package com.example.simsa_sukso.src.main

import android.os.Bundle
import com.example.simsa_sukso.R
import com.example.simsa_sukso.config.BaseActivity
import com.example.simsa_sukso.databinding.MainActivityBinding
import com.example.simsa_sukso.src.setting.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity: BaseActivity<MainActivityBinding>(MainActivityBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
//                    R.id.main_home -> {
//                        supportFragmentManager.beginTransaction()
//                    }
//                    R.id.main_search -> {
//                        supportFragmentManager.beginTransaction()
//                    }
//                    R.id.main_upload -> {
//                        supportFragmentManager.beginTransaction()
//                    }
//                    R.id.main_heart -> {
//                        supportFragmentManager.beginTransaction()
//                    }
                    R.id.main_setting -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, SettingFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                }
                true
            }
        )
    }
}