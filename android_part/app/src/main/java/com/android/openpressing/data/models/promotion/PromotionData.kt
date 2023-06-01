package com.android.openpressing.data.models.promotion

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class PromotionData(
    var id: Int? = null,
    var attributes: PromotionAttributes
):Parcelable
