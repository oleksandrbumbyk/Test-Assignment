package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserLocation(
    @SerializedName("city")
    var city: String? = "",
    @SerializedName("street")
    var street: String? = "",
    @SerializedName("timezone")
    var timezone: UserTimezone?,
    @SerializedName("coordinates")
    var coordinates: UserCoordinates?,
    @SerializedName("state")
    var state: String? = ""
)
