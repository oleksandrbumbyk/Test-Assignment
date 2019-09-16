package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserName(
    @SerializedName("last")
    var last: String? = "",
    @SerializedName("title")
    var title: String? = "",
    @SerializedName("first")
    var first: String? = ""
)
