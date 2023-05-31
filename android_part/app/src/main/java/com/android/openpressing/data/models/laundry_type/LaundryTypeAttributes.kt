package com.android.openpressing.data.models.laundry_type

import com.android.openpressing.data.models.laundry_category.laundry.Laundries
import com.google.gson.annotations.SerializedName
import java.util.*

data class LaundryTypeAttributes(
    @SerializedName("Title") var title: String ,
    var laundries: Laundries? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false ,
)
