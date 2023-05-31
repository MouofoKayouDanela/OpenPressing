package com.android.openpressing.data.models.message


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Messages(
    var data: MutableList<MessageData>
):Parcelable
