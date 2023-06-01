package com.android.openpressing.data.models.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users (
    var data: MutableList<UserData>
):Parcelable