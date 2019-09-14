package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserTimezone(
    @SerializedName("offset")
    val offset: String? = "",
    @SerializedName("description")
    val description: String? = ""
)
