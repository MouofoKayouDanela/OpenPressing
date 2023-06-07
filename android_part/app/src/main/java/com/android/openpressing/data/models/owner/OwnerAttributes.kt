package com.android.openpressing.data.models.owner

import android.os.Parcelable
import com.android.openpressing.data.models.pressing.Pressings
import com.android.openpressing.data.models.user.User
import com.android.openpressing.data.models.user.UserPermission
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class OwnerAttributes(
    @SerializedName("users_permissions_user") val user: UserPermission ,
    var pressings: Pressings? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
):Parcelable
