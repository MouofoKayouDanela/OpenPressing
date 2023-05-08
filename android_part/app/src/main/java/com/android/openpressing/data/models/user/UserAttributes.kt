package com.android.openpressing.data.models.user

import com.android.openpressing.data.models.utils.images.ImageInfo
import com.google.gson.annotations.SerializedName
import java.util.*

data class UserAttributes(
    var name: String ,
    var surname: String ,
    var birthday: Date ,
    var gender: String ,
    @SerializedName("phoneNumber") var phone_number: String ,
    @SerializedName("profilePicture") var profile_picture: ImageInfo ,
    var username: String ,
    var email: String ,
    var password: String ,
    var registerDate: Date ,
    var confirmed: Boolean ,
    var blocked: Boolean
)
