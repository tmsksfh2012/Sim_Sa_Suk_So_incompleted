package com.example.simsa_sukso.src.splash

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import com.example.simsa_sukso.config.BaseActivity
import com.example.simsa_sukso.databinding.SplashActivityBinding
import android.os.Handler
import com.example.simsa_sukso.src.login.LoginMainActivity

class SplashActivity: BaseActivity<SplashActivityBinding>(SplashActivityBinding::inflate) {
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handler = Handler(Looper.getMainLooper())

        handler.postDelayed({
        }, 1500)
        finish()
        startActivity(Intent(this, LoginMainActivity::class.java))
    }
}