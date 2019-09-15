package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserId(
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("value")
    var value: String? = ""
)
