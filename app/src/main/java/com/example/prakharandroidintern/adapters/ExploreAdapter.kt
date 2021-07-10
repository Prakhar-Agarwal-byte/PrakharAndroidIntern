package com.example.prakharandroidintern.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.example.prakharandroidintern.R
import com.example.prakharandroidintern.databinding.ItemExploreBinding
import com.example.prakharandroidintern.models.ExploreModal

class ExploreAdapter(val context: Context, var list: ArrayList<ExploreModal>, val listenerExplore: ExploreClickListener) :
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>(), Filterable {

    val listAll = ArrayList(list)

    class ExploreViewHolder(val itemExploreBinding: ItemExploreBinding) : RecyclerView.ViewHolder(itemExploreBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        return ExploreViewHolder(ItemExploreBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        val item = list[position]
        holder.itemExploreBinding.exploreItem = item
        holder.itemExploreBinding.flexboxLayout.removeAllViews()
        for (tag in item.tags) {
            val tvTag = TextView(context)
            tvTag.text = "#$tag"
            tvTag.setTextColor(context.getColor(R.color.tagsColor))
            tvTag.setPadding(8)
            holder.itemExploreBinding.flexboxLayout.addView(tvTag)
        }
        holder.itemExploreBinding.btnSave.setOnClickListener {
            listenerExplore.onItemClick(position)
        }
        holder.itemExploreBinding.executePendingBindings()
    }

    override fun getItemCount() = list.size

    override fun getFilter(): Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList: ArrayList<ExploreModal> = ArrayList()
            if (constraint.isNullOrBlank()) {
                filteredList.addAll(listAll)
            } else {
                for (exploreItem in listAll) {
                    for (tag in exploreItem.tags) {
                        if (tag.lowercase().contains(constraint.toString().lowercase())) {
                            filteredList.add(exploreItem)
                        }
                    }
                }
            }
            val filterResults: FilterResults = FilterResults()
            filterResults.values = filteredList
            return filterResults
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            list.clear()
            list.addAll(results!!.values as Collection<ExploreModal>)
            notifyDataSetChanged()
        }

    }

}

interface ExploreClickListener {
    fun onItemClick(position: Int)
}