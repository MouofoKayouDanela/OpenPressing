package com.android.openpressing.data.models.offer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OfferData(
    var id: Int? = null ,
    var attributes: OfferAttributes
):Parcelable
