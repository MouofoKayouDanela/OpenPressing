package com.android.openpressing.data.models.laundry_type

import android.os.Parcelable
import com.android.openpressing.data.models.laundry_category.laundry.Laundries
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
data class LaundryTypeAttributes(
    @SerializedName("Title") var title: String ,
    var laundries: Laundries? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false ,
):Parcelable
