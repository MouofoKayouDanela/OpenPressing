package com.android.openpressing.data.models.administrator

import com.android.openpressing.data.models.user.User
import com.android.openpressing.data.models.user.UserPermission
import com.google.gson.annotations.SerializedName
import java.util.Date

data class AdministratorAttributes(
    var createdAt: Date = Date(),
    var updatedAt: Date = Date(),
    var publishedAt: Date = Date(),
    @SerializedName("users_permissions_user") val user: UserPermission
)
