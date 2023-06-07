package com.android.openpressing.data.models.order

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Order(
    var data: OrderData
):Parcelable
