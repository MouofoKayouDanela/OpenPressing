package com.android.openpressing.data.models.client

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Client(
    var data: ClientData
):Parcelable
