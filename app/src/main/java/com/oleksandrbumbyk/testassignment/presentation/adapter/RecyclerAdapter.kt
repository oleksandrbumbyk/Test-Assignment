package com.oleksandrbumbyk.testassignment.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oleksandrbumbyk.testassignment.R
import com.oleksandrbumbyk.testassignment.presentation.adapter.item.BaseItemTypeEnum
import com.oleksandrbumbyk.testassignment.presentation.adapter.item.UserItem
import com.oleksandrbumbyk.testassignment.presentation.adapter.viewholder.UserViewHolder

class RecyclerAdapter(
    var itemListener: ItemListener = object : ItemListener {},
    var loadMoreListener: LoadMoreListener = object : LoadMoreListener {}
) : BaseRecyclerAdapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false), itemListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position >= itemCount - THRESHHOLD) loadMoreListener.loadMoreItems()
        val item = getItem(position)
        when (item.type) {
            BaseItemTypeEnum.USER -> (holder as UserViewHolder).bind(item as UserItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }
}
