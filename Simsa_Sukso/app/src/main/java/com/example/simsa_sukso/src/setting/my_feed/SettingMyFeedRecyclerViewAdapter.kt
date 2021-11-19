package com.example.simsa_sukso.src.setting.my_feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simsa_sukso.R

class SettingMyFeedRecyclerViewAdapter(iSettingMyFeedRecyclerView: ISettingMyFeedRecyclerView)
    :RecyclerView.Adapter<SettingMyFeedRecyclerViewHolder>(){

    private var myFeedList = mutableListOf<MyFeed>()
    lateinit var myFeedRecyclerViewHolder: SettingMyFeedRecyclerViewHolder
    var iMyFeedRecyclerView : ISettingMyFeedRecyclerView? = null

    init {
        this.iMyFeedRecyclerView = iSettingMyFeedRecyclerView
        myFeedList.apply {
            add(MyFeed(mainImg = R.drawable.ic_launcher_background))
            add(MyFeed(mainImg = R.drawable.ic_launcher_background))
            add(MyFeed(mainImg = R.drawable.ic_launcher_background))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingMyFeedRecyclerViewHolder {
        myFeedRecyclerViewHolder =
            SettingMyFeedRecyclerViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.setting_my_feed_item, parent, false)
            , this.iMyFeedRecyclerView!!)

        return myFeedRecyclerViewHolder
    }

    override fun onBindViewHolder(holder: SettingMyFeedRecyclerViewHolder, position: Int) {
        val item = this.myFeedList[position]
        holder.bindWithView(item.mainImg)
    }

    override fun getItemCount(): Int {
        return myFeedList.size
    }
}