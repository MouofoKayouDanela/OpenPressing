package com.android.openpressing.data.models.owner

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    var data: OwnerData
):Parcelable
