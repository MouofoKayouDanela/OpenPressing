package com.android.openpressing.data.models.laundry_type

import com.android.openpressing.data.models.laundry.Laundries
import com.google.gson.annotations.SerializedName

data class LaundryTypeAttributes(
    @SerializedName("Title") var title: String ,
    var laundries: Laundries? = null ,
    var confirmed: Boolean = true,
    var blocked: Boolean = false ,
)
