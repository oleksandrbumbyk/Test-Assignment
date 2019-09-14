package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserLocation(
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("street")
    val street: String? = "",
    @SerializedName("timezone")
    val timezone: UserTimezone?,
    @SerializedName("postcode")
    val postcode: Int? = 0,
    @SerializedName("coordinates")
    val coordinates: UserCoordinates?,
    @SerializedName("state")
    val state: String? = ""
)
