package com.android.openpressing.data.models.user

import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.quarter.QuarterInfo
import com.android.openpressing.data.models.utils.images.ImageInfo
import com.google.gson.annotations.SerializedName
import java.util.*

data class User (
    var id: Int? = null ,
    var name: String ,
    var surname: String ,
    @SerializedName("phoneNumber") var phone_number: String ,
    @SerializedName("profilePicture") var profile_picture: ImageInfo ,
    var username: String ,
    var email: String ,
    var password: String ,
    var quarter: QuarterInfo,
    var registerDate: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)