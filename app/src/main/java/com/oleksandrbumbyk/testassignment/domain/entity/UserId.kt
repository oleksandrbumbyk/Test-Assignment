package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserId(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("value")
    val value: String? = ""
)
