package com.android.openpressing.data.models.order

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderData(
    var id: Int? = null ,
    var attributes: OrderAttributes
):Parcelable
