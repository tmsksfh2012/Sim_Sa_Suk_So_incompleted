package com.example.simsa_sukso.config

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.simsa_sukso.R
import com.example.simsa_sukso.src.utils.API
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {
    //server address
    val API_URL = API.BASE_URL

    //전역변수
    companion object {
        //sSharedPreference
        lateinit var sSharedPreferences: SharedPreferences

        //jwt Token
        val X_ACCESS_TOKEN = "X-ACESS-TOKEN"

        //retrofit
        lateinit var sRetrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()
        sSharedPreferences =
                applicationContext.getSharedPreferences("SIMSA_SUKSO", Context.MODE_PRIVATE)

        val keyHash = Utility.getKeyHash(this)

        KakaoSdk.init(this, getString(R.string.kakao_app_key))

        Log.d("KEY_HASH", keyHash)

        initRetrofitInstance()
    }

    //retrofit 인스턴스 생성
    //연결 타임아웃 5초
    private fun initRetrofitInstance() {
        val client: OkHttpClient = OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .addInterceptor(HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)) //API Response 로그 작성용
                .addNetworkInterceptor(XAccessTokenInterceptor())
                .build()

        //sRetrofit 에 API URL, 인터셉터, Gson 담아줌
        sRetrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}