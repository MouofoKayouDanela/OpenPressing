package com.android.openpressing.data.models.service

import com.android.openpressing.data.models.service_category.ServiceCategory
import com.android.openpressing.data.models.agency_service.AgencyServices
import com.android.openpressing.data.models.service_type.ServiceType
import com.android.openpressing.data.models.utils.images.ImageInformation
import com.google.gson.annotations.SerializedName
import java.util.Date

data class ServiceAttributes(
    var category: ServiceCategory,
    var type: ServiceType,
    var serviceImage: ImageInformation,
    var agency_services: AgencyServices? = null,
    @SerializedName("createdAt") var created_at: Date = Date() ,
    @SerializedName("updateAt") var updated_at: Date = Date() ,
    @SerializedName("publishedAt") var published_at: Date = Date() ,
    var confirmed: Boolean = true,
    var blocked: Boolean = false,
)
