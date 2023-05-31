package com.android.openpressing.data.models.client

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class ClientData(
    var id: Int? = null ,
    var attributes: ClientAttributes
):Parcelable
