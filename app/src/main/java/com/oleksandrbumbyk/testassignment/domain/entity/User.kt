package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("nat")
    val nat: String? = "",
    @SerializedName("gender")
    val gender: String? = "",
    @SerializedName("phone")
    val phone: String? = "",
    @SerializedName("dob")
    val dob: UserDob?,
    @SerializedName("name")
    val name: UserName?,
    @SerializedName("registered")
    val registered: UserRegistered?,
    @SerializedName("location")
    val location: UserLocation?,
    @SerializedName("id")
    val id: UserId?,
    @SerializedName("login")
    val login: UserLogin?,
    @SerializedName("cell")
    val cell: String? = "",
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("picture")
    val picture: UserPicture?
)
