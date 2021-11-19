package com.example.simsa_sukso.src.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.simsa_sukso.config.BaseActivity
import com.example.simsa_sukso.databinding.LoginMainActivityBinding
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.example.simsa_sukso.src.utils.Constants

class LoginMainActivity
    :BaseActivity<LoginMainActivityBinding>(LoginMainActivityBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding.loginKakaoBtn.setOnClickListener {
//                    finish()
//                    startActivity(Intent(this, LoginRegisterActivity::class.java))
//        }

        // 로그인 공통 callback 구성
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.d(Constants.TAG, "err")
                //Login Fail
            }
            else if (token != null) {
                finish()
                startActivity(Intent(this, LoginRegisterActivity::class.java))
            }
        }

        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        binding.loginKakaoBtn.setOnClickListener {
            LoginClient.instance.run {
                Log.d(Constants.TAG, "In run")
                if (isKakaoTalkLoginAvailable(this@LoginMainActivity)) {
                    Log.d(Constants.TAG, "In if")
                    loginWithKakaoTalk(this@LoginMainActivity, callback = callback)
                } else {
                    Log.d(Constants.TAG, "In else")
                    loginWithKakaoAccount(this@LoginMainActivity, callback = callback)
                }
            }
        }
    }
}