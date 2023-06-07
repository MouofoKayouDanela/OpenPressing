package com.android.openpressing.data.models.promotion

import android.os.Parcelable
import com.android.openpressing.data.models.offer.Offer
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date
@Parcelize

data class PromotionAttributes (
    @SerializedName("MinQuantity") var minimal_quantity: Int,
    @SerializedName("SubstractPercentage") var reduction_percentage: Double,
    @SerializedName("CreationDate") var creation_date: Date,
    @SerializedName("ExpiredDate") var expired_date: Date,
    var offer: Offer,
    var createdAt: Date = Date(),
    var updatedAt: Date = Date(),
    var publishedAt: Date = Date(),
    var confirmed: Boolean = true,
    var blocked: Boolean = false
):Parcelable
