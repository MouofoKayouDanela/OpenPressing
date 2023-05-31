package com.android.openpressing.data.models.service

import android.os.Parcelable
import com.android.openpressing.data.models.service_category.ServiceCategory
import com.android.openpressing.data.models.agency_service.AgencyServices
import com.android.openpressing.data.models.service_type.ServiceType
import com.android.openpressing.data.models.utils.images.ImageInfoData
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date
@Parcelize
data class ServiceAttributes(
    var category: ServiceCategory,
    var type: ServiceType,
    var serviceImage: ImageInfoData,
    var agency_services: AgencyServices? = null,
    @SerializedName("createdAt") var created_at: Date = Date() ,
    @SerializedName("updateAt") var updated_at: Date = Date() ,
    @SerializedName("publishedAt") var published_at: Date = Date() ,
    var confirmed: Boolean = true,
    var blocked: Boolean = false,
):Parcelable
