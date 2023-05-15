package com.android.openpressing.data.models.annonce

import com.android.openpressing.data.models.offer.Offers
import com.google.gson.annotations.SerializedName

data class AnnounceAttributes(
    @SerializedName("Description") var description: String ,
    var offers: Offers? = null ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
