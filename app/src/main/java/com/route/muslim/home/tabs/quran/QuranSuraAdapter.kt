package com.route.muslim.home.tabs.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.muslim.databinding.ItemSuraNameChapterBinding

class QuranSuraAdapter(private val itemList: List<String>) :
    RecyclerView.Adapter<QuranSuraAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: ItemSuraNameChapterBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemSuraNameChapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.suraText.text = itemList[position]
        if (onItemClickListener != null) {
            holder.viewBinding.suraText.setOnClickListener {
                onItemClickListener?.onItemClick(position, itemList[position])
            }
        }

    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, name: String)
    }
}