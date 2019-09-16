package com.oleksandrbumbyk.testassignment.remote.model

import com.google.gson.annotations.SerializedName

data class UsersResponseInfo(
    @SerializedName("seed")
    var seed: String? = "",
    @SerializedName("page")
    var page: Int? = 0,
    @SerializedName("results")
    var results: Int? = 0,
    @SerializedName("version")
    var version: String? = ""
)
