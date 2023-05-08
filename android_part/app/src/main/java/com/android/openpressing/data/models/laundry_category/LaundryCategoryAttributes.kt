package com.android.openpressing.data.models.laundry_category

import com.android.openpressing.data.models.laundry.Laundries
import com.google.gson.annotations.SerializedName

data class LaundryCategoryAttributes(
    @SerializedName("Name") var name: String ,
    var laundries: Laundries ,
    var confirmed: Boolean ,
    var blocked: Boolean
)
