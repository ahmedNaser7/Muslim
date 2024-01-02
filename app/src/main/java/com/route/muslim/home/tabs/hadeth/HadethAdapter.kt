package com.route.muslim.home.tabs.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.muslim.databinding.ItemHadethNameChapterBinding
import com.route.muslim.model.Hadeth

class HadethAdapter(private var itemList: List<Hadeth?>?) :
    RecyclerView.Adapter<HadethAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: ItemHadethNameChapterBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemHadethNameChapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = itemList!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.suraText.text = itemList!![position]?.title
        if (onItemClickListener != null) {
            holder.viewBinding.suraText.setOnClickListener {
                onItemClickListener?.onItemClick(position, itemList!![position]!!)
            }
        }

    }

    fun bindHadeth(list: List<Hadeth>) {
        this.itemList = list
    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, name: Hadeth)
    }
}