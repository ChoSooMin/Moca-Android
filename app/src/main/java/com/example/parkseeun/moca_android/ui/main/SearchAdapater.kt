package com.example.parkseeun.moca_android.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.parkseeun.moca_android.R
import de.hdodenhof.circleimageview.CircleImageView

class SearchAdapater(val context : Context, val dataList : ArrayList<SearchResultData>) : RecyclerView.Adapter<SearchAdapater.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        // 뷰 인플레이트
        val view : View = LayoutInflater.from(context).inflate(R.layout.rv_item_search, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // 뷰 바인딩
        Glide.with(context).load("https://s3.ap-northeast-2.amazonaws.com/project-sopt/%25E1%2584%258E%25E1%2585%25AC%25E1%2584%2589%25E1%2585%25A5%25E1%2586%25AB%25E").into(holder.civ_search_resultImage)
        holder.tv_search_cafeName.text = dataList[position].cafeName
        holder.tv_search_cafeLocation.text = dataList[position].cafeLocation

        // 클릭 리스너
        holder.relative_search_result.setOnClickListener {


        }
    }

    // View Holder
    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val relative_search_result : RelativeLayout = itemView.findViewById(R.id.relative_search_result) as RelativeLayout
        val civ_search_resultImage : CircleImageView = itemView.findViewById(R.id.civ_search_resultImage) as CircleImageView
        val tv_search_cafeName : TextView = itemView.findViewById(R.id.tv_search_cafeName) as TextView
        val tv_search_cafeLocation : TextView = itemView.findViewById(R.id.tv_search_cafeLocation) as TextView
    }
}