package com.oleksandrbumbyk.testassignment.presentation.viewmodel.mapper

import com.oleksandrbumbyk.testassignment.domain.entity.User
import com.oleksandrbumbyk.testassignment.presentation.adapter.item.BaseItem
import com.oleksandrbumbyk.testassignment.presentation.adapter.item.UserItem

class UserMapper {

    fun toItems(newEntities: List<User>, previouslyLoaded: List<BaseItem> = listOf()): MutableList<BaseItem> {
        val items = mutableListOf<BaseItem>()
        items.addAll(previouslyLoaded)
        for (user in newEntities) items.add(UserItem(user))
        return items
    }
}
