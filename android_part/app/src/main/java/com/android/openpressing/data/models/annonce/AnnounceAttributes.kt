package com.android.openpressing.data.models.annonce

import com.android.openpressing.data.models.offer.Offers
import com.google.gson.annotations.SerializedName

data class AnnounceAttributes(
    @SerializedName("Description") var description: String ,
    var offers: Offers ,
    var confirmed: Boolean ,
    var blocked: Boolean
)
