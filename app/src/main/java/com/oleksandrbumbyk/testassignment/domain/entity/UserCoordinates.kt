package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserCoordinates(
    @SerializedName("latitude")
    var latitude: String? = "",
    @SerializedName("longitude")
    var longitude: String? = ""
)
