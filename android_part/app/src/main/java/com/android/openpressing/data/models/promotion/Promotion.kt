package com.android.openpressing.data.models.promotion

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Promotion (
    var data: PromotionData
):Parcelable
