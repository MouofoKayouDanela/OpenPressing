package com.android.openpressing.data.models.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserPermission (
    var data: UserData
):Parcelable