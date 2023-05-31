package com.android.openpressing.data.models.user

import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.service.Services
import com.android.openpressing.data.models.utils.images.ImageInfo
import com.google.gson.annotations.SerializedName
import java.util.*

data class UserAttributes(
    var name: String ,
    var surname: String ,
    @SerializedName("phoneNumber") var phone_number: String ,
    @SerializedName("profilePicture") var profile_picture: ImageInfo ,
    var username: String ,
    var email: String ,
    var password: String ,
    var quarter: Quarter ,
    var createdAt: Date = Date() ,
    var updatedDate: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
