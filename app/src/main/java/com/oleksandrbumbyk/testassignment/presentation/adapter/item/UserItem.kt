package com.oleksandrbumbyk.testassignment.presentation.adapter.item

import com.oleksandrbumbyk.testassignment.domain.entity.User

data class UserItem(val user: User) : BaseItem() {

    override val type: Int
        get() = BaseItemTypeEnum.USER
}
