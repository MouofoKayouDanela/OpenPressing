package com.android.openpressing.data.models

import android.media.Image
import java.util.*

data class User (
    var id: Int ,
    var name: String ,
    var surname: String ,
    var birthday: Date ,
    var gender: String ,
    var phoneNumber: String ,
    var profilePicture: Image ,
    var username: String ,
    var email: String ,
    var password: String ,
    var registerDate: Date ,
    var confirmed: Boolean ,
    var blocked: Boolean
)