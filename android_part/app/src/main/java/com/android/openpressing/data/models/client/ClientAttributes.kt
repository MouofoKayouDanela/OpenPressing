package com.android.openpressing.data.models.client

import com.android.openpressing.data.models.requirement.Requirements
import com.android.openpressing.data.models.user.UserPermission
import com.google.gson.annotations.SerializedName

data class ClientAttributes(
    @SerializedName("users_permissions_user") val user: UserPermission ,
    @SerializedName("besoins") var requirements: Requirements? = null
) {

}
