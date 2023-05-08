package com.android.openpressing.data.models.promotion

import com.android.openpressing.data.models.offer.Offer
import com.google.gson.annotations.SerializedName
import java.util.Date

data class PromotionAttributes (
    @SerializedName("MinQuantity") var minimal_quantity: Int,
    @SerializedName("SubstractPercentage") var reduction_percentage: Double,
    @SerializedName("CreationDate") var creation_date: Date,
    @SerializedName("ExpiredDate") var expired_date: Date,
    var offer: Offer,
    var confirmed: Boolean,
    var blocked: Boolean
)
