package com.oleksandrbumbyk.testassignment.presentation.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.oleksandrbumbyk.testassignment.presentation.adapter.ItemListener
import com.oleksandrbumbyk.testassignment.presentation.adapter.binding.UserBinder
import com.oleksandrbumbyk.testassignment.presentation.adapter.item.UserItem
import kotlinx.android.synthetic.main.item_user.view.*

class UserViewHolder(itemView: View, private val listener: ItemListener) : RecyclerView.ViewHolder(itemView) {

    private lateinit var item: UserItem

    init {
        itemView.setOnClickListener { listener.onUserClick(item) }
    }

    fun bind(item: UserItem) {
        this.item = item
        UserBinder.bindImage(itemView.context, itemView.ivAvatar, item.user)
        UserBinder.bindAge(itemView.context, itemView.tvAge, item.user)
        UserBinder.bindLocation(itemView.tvLocation, item.user)
        UserBinder.bindName(itemView.tvName, item.user)
        UserBinder.bindEmail(itemView.tvEmail, item.user)
        UserBinder.bindPhone(itemView.tvPhone, item.user)
    }
}
