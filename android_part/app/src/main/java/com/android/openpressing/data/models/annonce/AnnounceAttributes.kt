package com.android.openpressing.data.models.annonce

import android.graphics.ImageDecoder.ImageInfo
import com.android.openpressing.data.models.offer.Offers
import com.android.openpressing.data.models.utils.images.ImageInformation
import com.google.gson.annotations.SerializedName
import java.util.*

data class AnnounceAttributes(
    @SerializedName("Description") var description: String ,
    var image: ImageInformation ,
    var offers: Offers? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
