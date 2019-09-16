package com.oleksandrbumbyk.testassignment.domain.entity

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("nat")
    var nat: String? = "",
    @SerializedName("gender")
    var gender: String? = "",
    @SerializedName("phone")
    var phone: String? = "",
    @SerializedName("dob")
    var dob: UserDob?,
    @SerializedName("name")
    var name: UserName?,
    @SerializedName("registered")
    var registered: UserRegistered?,
    @SerializedName("location")
    var location: UserLocation?,
    @SerializedName("id")
    var id: UserId?,
    @SerializedName("login")
    var login: UserLogin?,
    @SerializedName("cell")
    var cell: String? = "",
    @SerializedName("email")
    var email: String? = "",
    @SerializedName("picture")
    var picture: UserPicture?
)
