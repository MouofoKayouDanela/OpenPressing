package com.android.openpressing.data.models.pressing

import com.android.openpressing.data.models.agency.Agencies
import com.android.openpressing.data.models.owner.Owner
import com.android.openpressing.data.models.utils.images.ImageInformation
import com.google.gson.annotations.SerializedName

data class PressingAttributes(
    @SerializedName("Name") var name: String ,
    @SerializedName("proprietaire") val owner: Owner ,
    var logo: ImageInformation,
    var agencies: Agencies? = null ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
