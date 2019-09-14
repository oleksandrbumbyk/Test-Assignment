package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserRegistered(
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("age")
    val age: Int? = 0
)
