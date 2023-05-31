package com.android.openpressing.data.models.message

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MessageData(
    var id: Int? = null ,
    var attributes: MessageAttributes
):Parcelable
