package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class UserLogin(
    @SerializedName("sha1")
    val sha1: String? = "",
    @SerializedName("password")
    val password: String? = "",
    @SerializedName("salt")
    val salt: String? = "",
    @SerializedName("sha256")
    val sha256: String? = "",
    @SerializedName("uuid")
    val uuid: String? = "",
    @SerializedName("username")
    val username: String? = "",
    @SerializedName("md5")
    val md: String? = ""
)
