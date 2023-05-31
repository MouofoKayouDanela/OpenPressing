package com.android.openpressing.data.models.annonce

import android.os.Parcelable
import com.android.openpressing.data.models.offer.Offers
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize

data class AnnounceAttributes(
    @SerializedName("Description") var description: String ,
    var offers: Offers? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
):Parcelable
