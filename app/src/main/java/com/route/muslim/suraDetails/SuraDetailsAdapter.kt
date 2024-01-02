package com.route.muslim.suraDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.muslim.databinding.ItemSuraChapterBinding

class SuraDetailsAdapter(val itemList: List<String>?) :
    RecyclerView.Adapter<SuraDetailsAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: ItemSuraChapterBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemSuraChapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = itemList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.suraDetails.text = itemList!![position]

    }


}