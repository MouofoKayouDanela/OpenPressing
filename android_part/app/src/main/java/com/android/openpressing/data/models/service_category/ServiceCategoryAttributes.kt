package com.android.openpressing.data.models.service_category

import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.service.Services
import com.google.gson.annotations.SerializedName
import java.util.*

data class ServiceCategoryAttributes (
    @SerializedName("Name") var name: String ,
    @SerializedName("createdAt") var created_at: Date ,
    @SerializedName("updateAt") var updated_at: Date ,
    @SerializedName("publishedAt") var published_at: Date ,
    var confirmed: Boolean = true,
    var blocked: Boolean = false ,
    var services: Services? = null ,
)
