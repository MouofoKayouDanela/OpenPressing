package com.android.openpressing.data.models.service_type

import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.service.Services
import com.google.gson.annotations.SerializedName
import java.util.*

data class ServiceTypeAttributes(
    @SerializedName("Title") var title: String ,
    @SerializedName("createdAt") var created_at: Date = Date() ,
    @SerializedName("updateAt") var updated_at: Date = Date() ,
    @SerializedName("publishedAt") var published_at: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false ,
    var services: Services? = null ,
)
