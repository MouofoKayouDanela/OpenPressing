package com.android.openpressing.data.models.service

import com.android.openpressing.data.models.service_category.ServiceCategory
import com.android.openpressing.data.models.agency_service.AgencyService
import com.android.openpressing.data.models.agency_service.AgencyServices
import com.android.openpressing.data.models.service_type.ServiceType
import com.android.openpressing.data.models.utils.images.ImageInfo
import com.android.openpressing.data.models.utils.images.ImageInfos
import com.google.gson.annotations.SerializedName
import java.util.Date

data class ServiceAttributes(
    @SerializedName("createdAt") var created_at: Date,
    @SerializedName("updateAt") var updated_at: Date,
    @SerializedName("publishedAt") var published_at: Date,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false ,
    var category: ServiceCategory ,
    var type: ServiceType ,
    var agency_services: AgencyServices? = null ,
    var serviceImage: ImageInfos ,
)
