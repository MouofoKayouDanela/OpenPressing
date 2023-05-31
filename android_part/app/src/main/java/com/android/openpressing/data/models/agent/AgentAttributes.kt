package com.android.openpressing.data.models.agent

import android.os.Parcelable
import com.android.openpressing.data.models.privilege.Privilege
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.user.UserPermission
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize

data class AgentAttributes(
    @SerializedName("users_permissions_user") val user: UserPermission ,
    var agency: Agency ,
    var privilege: Privilege ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
):Parcelable
