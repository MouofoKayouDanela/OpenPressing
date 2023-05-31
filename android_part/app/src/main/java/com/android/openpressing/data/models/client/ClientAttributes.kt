package com.android.openpressing.data.models.client

import android.os.Parcelable
import com.android.openpressing.data.models.requirement.Requirements
import com.android.openpressing.data.models.user.UserPermission
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize

data class ClientAttributes(
    @SerializedName("users_permissions_user") val user: UserPermission ,
    @SerializedName("besoins") var requirements: Requirements? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
):Parcelable
