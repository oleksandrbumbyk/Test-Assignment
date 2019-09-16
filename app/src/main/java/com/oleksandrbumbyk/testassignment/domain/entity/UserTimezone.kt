package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserTimezone(
    @SerializedName("offset")
    var offset: String? = "",
    @SerializedName("description")
    var description: String? = ""
)
