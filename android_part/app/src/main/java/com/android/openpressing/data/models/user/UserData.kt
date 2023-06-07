package com.android.openpressing.data.models.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    var id: Int? = null ,
    var attributes: UserAttributes
):Parcelable
