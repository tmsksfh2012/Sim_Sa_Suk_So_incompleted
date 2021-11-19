package com.example.simsa_sukso.src.setting.my_feed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.setting_my_feed_item.view.*

class SettingMyFeedRecyclerViewHolder(itemView: View, iSettingMyFeedRecyclerView: ISettingMyFeedRecyclerView)
    :RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var iMyFeedRecyclerView : ISettingMyFeedRecyclerView
    private val myFeedItem = itemView.my_feed_item
    private var myFeedImg = itemView.my_feed_img

    init {
        myFeedItem.setOnClickListener(this)
        this.iMyFeedRecyclerView = iSettingMyFeedRecyclerView
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    fun bindWithView(myFeedImageURL : Int) {
        myFeedImg.setImageResource(myFeedImageURL)
    }
}