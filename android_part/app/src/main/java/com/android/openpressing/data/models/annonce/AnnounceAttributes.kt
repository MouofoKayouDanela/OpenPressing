package com.android.openpressing.data.models.annonce

import com.android.openpressing.data.models.offer.Offers
import com.google.gson.annotations.SerializedName
import java.util.*

data class AnnounceAttributes(
    @SerializedName("Description") var description: String ,
    var offers: Offers? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
