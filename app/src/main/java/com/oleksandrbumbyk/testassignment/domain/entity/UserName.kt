package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserName(
    @SerializedName("last")
    val last: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("first")
    val first: String? = ""
)
