package com.android.openpressing.data.models.laundry_category

import com.android.openpressing.data.models.laundry.Laundries
import com.google.gson.annotations.SerializedName
import java.util.*

data class LaundryCategoryAttributes(
    @SerializedName("Name") var name: String ,
    var laundries: Laundries? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
