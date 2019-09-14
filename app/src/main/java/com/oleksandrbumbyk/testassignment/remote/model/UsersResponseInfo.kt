package com.oleksandrbumbyk.testassignment.remote.model

import com.google.gson.annotations.SerializedName

data class UsersResponseInfo(
    @SerializedName("seed")
    val seed: String? = "",
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: Int? = 0,
    @SerializedName("version")
    val version: String? = ""
)
