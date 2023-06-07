package com.android.openpressing.data.models.pressing

import android.os.Parcelable
import com.android.openpressing.data.models.owner.Owner
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pressing(
    var data: PressingData
):Parcelable
