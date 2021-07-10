package com.example.prakharandroidintern.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prakharandroidintern.databinding.ItemTrendingBinding
import com.example.prakharandroidintern.models.TrendingModal

class TrendingAdapter(val list: List<TrendingModal>) : RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>() {


    class TrendingViewHolder(val itemTrendingBinding: ItemTrendingBinding) : RecyclerView.ViewHolder(itemTrendingBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        return TrendingViewHolder(ItemTrendingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        val item = list[position]
        holder.itemTrendingBinding.trendingItem = item
        holder.itemTrendingBinding.executePendingBindings()
    }

    override fun getItemCount() = list.size
}