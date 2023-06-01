package com.android.openpressing.data.models.service_category

import android.os.Parcelable
import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.service.Services
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
data class ServiceCategoryAttributes (
    @SerializedName("Name") var name: String ,
    var services: Services? = null ,
    @SerializedName("createdAt") var created_at: Date = Date() ,
    @SerializedName("updateAt") var updated_at: Date = Date() ,
    @SerializedName("publishedAt") var published_at: Date = Date() ,
    var confirmed: Boolean = true,
    var blocked: Boolean = false ,
):Parcelable
