package com.android.openpressing.data.models.owner

import com.android.openpressing.data.models.pressing.Pressings
import com.android.openpressing.data.models.user.User
import com.android.openpressing.data.models.user.UserPermission
import com.google.gson.annotations.SerializedName

data class OwnerAttributes(
    @SerializedName("users_permissions_user") val user: UserPermission ,
    var pressings: Pressings? = null
)
