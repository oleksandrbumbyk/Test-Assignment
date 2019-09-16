package com.oleksandrbumbyk.testassignment.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.oleksandrbumbyk.testassignment.presentation.adapter.item.BaseItem

abstract class BaseRecyclerAdapter<V : RecyclerView.ViewHolder> : RecyclerView.Adapter<V>() {

    companion object {
        const val THRESHOLD = 5
    }

    private var items = mutableListOf<BaseItem>()

    override fun getItemCount(): Int = items.size

    fun getItem(position: Int): BaseItem = items[position]

    fun getItems(): MutableList<BaseItem> = items

    fun resetItems(newList: MutableList<BaseItem>) {
        items = newList
        notifyDataSetChanged()
    }
}
