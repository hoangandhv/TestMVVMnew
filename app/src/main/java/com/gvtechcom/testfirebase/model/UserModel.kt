package com.gvtechcom.testfirebase.model

import com.google.gson.annotations.SerializedName

class UserModel(
    @SerializedName("accountName")
    var accountName: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("numberPhone")
    var numberPhone: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("startTime")
    var startTime: String,
    @SerializedName("endTime")
    var endTime: String
){
    val fullname = accountName+email
}