package com.android.openpressing.data.models.agent

import com.android.openpressing.data.models.privilege.Privilege
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.user.UserPermission
import com.google.gson.annotations.SerializedName

data class AgentAttributes(
    @SerializedName("users_permissions_user") val user: UserPermission ,
    var agency: Agency ,
    var privilege: Privilege
)
