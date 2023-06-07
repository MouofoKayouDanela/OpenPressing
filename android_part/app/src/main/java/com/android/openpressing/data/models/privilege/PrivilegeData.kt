package com.android.openpressing.data.models.privilege

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class PrivilegeData(
    var id: Int? = null ,
    var attributes: PrivilegeAttributes
):Parcelable
