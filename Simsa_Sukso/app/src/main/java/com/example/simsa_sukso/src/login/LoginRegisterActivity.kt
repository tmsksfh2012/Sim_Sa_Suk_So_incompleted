package com.example.simsa_sukso.src.login

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.annotation.RequiresApi
import com.example.simsa_sukso.R
import com.example.simsa_sukso.config.BaseActivity
import com.example.simsa_sukso.databinding.LoginRegisterActivityBinding
import com.example.simsa_sukso.src.main.MainActivity

class LoginRegisterActivity
    :BaseActivity<LoginRegisterActivityBinding>(LoginRegisterActivityBinding::inflate){

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        //hash key
//        try {
//            val info : PackageInfo
//                    = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNING_CERTIFICATES)
//
//            val signingInfo = info.signingInfo.apkContentsSigners
//
//            for(signature in signingInfo) {
//                val messageDigest = MessageDigest.getInstance("SHA")
//                messageDigest.update(signature.toByteArray())
//                val keyHash = String(Base64.encode(messageDigest.digest(), 0))
//                Log.d("KeyHash", keyHash)
//            }
//        } catch (e : Exception) {
//            Log.e("Exception", e.toString())
//        }

        val reg = Regex("[a-z0-9]{1,8}\$")

        binding.registerEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.registerEditText.text.matches(reg)) {
                    binding.registerBtn.setBackgroundColor(resources.getColor(R.color.main_color, theme))
                }
                else {
                    binding.registerBtn.setBackgroundColor(resources.getColor(R.color.gray, theme))
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        binding.registerBtn.setOnClickListener {
            if(binding.registerEditText.text.matches(reg)) {
                finish()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}