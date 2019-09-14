package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserPicture(
    @SerializedName("thumbnail")
    val thumbnail: String? = "",
    @SerializedName("large")
    val large: String? = "",
    @SerializedName("medium")
    val medium: String? = ""
)
