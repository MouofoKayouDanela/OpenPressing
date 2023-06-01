package com.android.openpressing.data.models.message

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
data class Message (
    var data: MessageData
):Parcelable
