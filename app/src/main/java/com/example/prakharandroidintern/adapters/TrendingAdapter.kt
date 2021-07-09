package com.example.prakharandroidintern.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.prakharandroidintern.R
import com.example.prakharandroidintern.models.TrendingModal

class TrendingAdapter(val list: List<TrendingModal>) : RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>() {


    class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvtitle: TextView = itemView.findViewById<TextView>(R.id.tv_title)
        val tvSubtitle: TextView = itemView.findViewById<TextView>(R.id.tv_subtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        return TrendingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_trending, parent,false))
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        val item = list[position]
        holder.tvtitle.text = item.tag.toString()
        holder.tvSubtitle.text = "${item.numOfPeople.toString()} people nearby"
    }

    override fun getItemCount() = list.size
}