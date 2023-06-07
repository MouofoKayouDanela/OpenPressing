package com.android.openpressing.data.models.utils.user

import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.utils.images.ImageInfo
import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.Part
import java.util.*

/*@Multipart
data class RequestUser(
    @Part ("id") val id: RequestBody? = null,
    @Part ("name") var name: RequestBody,
    @Part ("surname") var surname: RequestBody,
    @Part("phoneNumber") var phone_number: RequestBody,
    @Part("profilePicture") var profile_picture: MultipartBody.Part?,
    @Part ("username") var username: RequestBody,
    @Part ("email") var email: RequestBody,
    @Part ("password") var password: RequestBody,
    @Part ("quarter") var quarter: RequestBody,
    @Part ("createdAt") var createdAt: Date = Date().toRequestBody(),
    var updatedDate: Date = Date(),
    var confirmed: Boolean = true,
    var blocked: Boolean = false
)*/
