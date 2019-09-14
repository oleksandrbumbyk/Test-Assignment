package com.oleksandrbumbyk.testassignment.remote.model

import com.google.gson.annotations.SerializedName
import com.oleksandrbumbyk.testassignment.domain.entity.User

data class UsersResponse(
    @SerializedName("results")
    val results: List<User>?,
    @SerializedName("info")
    val info: UsersResponseInfo?
)
