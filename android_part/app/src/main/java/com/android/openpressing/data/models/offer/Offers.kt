package com.android.openpressing.data.models.offer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Offers(
    var data: MutableList<OfferData>
):Parcelable
