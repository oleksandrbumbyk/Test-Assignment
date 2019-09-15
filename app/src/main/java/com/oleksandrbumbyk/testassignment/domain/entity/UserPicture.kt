package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserPicture(
    @SerializedName("thumbnail")
    var thumbnail: String? = "",
    @SerializedName("large")
    var large: String? = "",
    @SerializedName("medium")
    var medium: String? = ""
)
