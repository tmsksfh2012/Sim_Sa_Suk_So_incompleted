package com.example.simsa_sukso.src.setting.my_feed

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simsa_sukso.R
import com.example.simsa_sukso.config.BaseFragment
import com.example.simsa_sukso.databinding.SettingMyFeedFragmentBinding

class SettingMyFeedFragment()
    :BaseFragment<SettingMyFeedFragmentBinding>(SettingMyFeedFragmentBinding::bind, R.layout.setting_my_feed_fragment)
    ,ISettingMyFeedRecyclerView{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myFeedRecyclerViewAdapter = SettingMyFeedRecyclerViewAdapter(this)

        val myLinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.myFeedRecyclerView.apply {
            layoutManager = myLinearLayoutManager
            adapter = myFeedRecyclerViewAdapter
        }
    }

    override fun onMyFeedItemClicked(position: Int) {
        TODO("Not yet implemented")
    }


}