package com.route.muslim.home.tabs.athkar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.route.muslim.databinding.ItemAthkarChapterBinding
import com.route.muslim.model.Athkar

class AthkarAdapter(var itemList: List<Athkar>? = null) : Adapter<AthkarAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: ItemAthkarChapterBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemAthkarChapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = itemList!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.content.text = itemList!![position].content
    }

    fun bindAthkar(athkarList: MutableList<Athkar>) {
        itemList = athkarList
    }
}