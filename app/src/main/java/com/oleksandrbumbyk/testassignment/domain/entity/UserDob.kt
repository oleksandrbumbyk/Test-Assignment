package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserDob(
    @SerializedName("date")
    var date: String? = "",
    @SerializedName("age")
    var age: Int? = 0
)
