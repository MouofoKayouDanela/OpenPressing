package com.android.openpressing.data.models.client

import com.android.openpressing.data.models.requirement.Requirements
import com.android.openpressing.data.models.user.UserPermission
import com.google.gson.annotations.SerializedName
import java.util.*

data class ClientAttributes(
    @SerializedName("users_permissions_user") val user: UserPermission ,
    @SerializedName("besoins") var requirements: Requirements? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
)
