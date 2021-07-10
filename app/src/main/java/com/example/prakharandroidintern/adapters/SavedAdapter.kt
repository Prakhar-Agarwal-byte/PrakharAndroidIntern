package com.example.prakharandroidintern.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.example.prakharandroidintern.R
import com.example.prakharandroidintern.databinding.ItemSavedBinding
import com.example.prakharandroidintern.models.ExploreModal

class SavedAdapter(val context: Context, var list: List<ExploreModal>, val listener: SavedClickListener) :
    RecyclerView.Adapter<SavedAdapter.SavedViewHolder>() {

    class SavedViewHolder(val itemSavedBinding: ItemSavedBinding) : RecyclerView.ViewHolder(itemSavedBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedViewHolder {
        return SavedViewHolder(ItemSavedBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: SavedViewHolder, position: Int) {
        val item = list[position]
        holder.itemSavedBinding.exploreItem = item
        holder.itemSavedBinding.flexboxLayoutSaved.removeAllViews()
        for (tag in item.tags) {
            val tvTag = TextView(context)
            tvTag.text = "#$tag"
            tvTag.setTextColor(context.getColor(R.color.tagsColor))
            tvTag.setPadding(8)
            holder.itemSavedBinding.flexboxLayoutSaved.addView(tvTag)
        }
        holder.itemSavedBinding.btnSaveSaved.setOnClickListener {
            listener.onItemClick(position)
        }
        holder.itemSavedBinding.executePendingBindings()
    }

    override fun getItemCount() = list.size

    fun updateList(list: List<ExploreModal>) {
        this.list = list
        notifyDataSetChanged()
    }

}

interface SavedClickListener {
    fun onItemClick(position: Int)
}