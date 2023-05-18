package com.android.openpressing.data.models.laundry

import com.android.openpressing.data.models.agency_laundry.AgencyLaundries
import com.android.openpressing.data.models.laundry_category.LaundryCategory
import com.android.openpressing.data.models.laundry_type.LaundryType
import com.android.openpressing.data.models.requirement_detail.RequirementDetail
import com.android.openpressing.data.models.utils.images.ImageInfos

data class LaundryAttributes(
    var category: LaundryCategory ,
    var type: LaundryType ,
    var agency_laundries: AgencyLaundries? = null ,
    var requirement_details: RequirementDetail? = null ,
    var laundryImage: ImageInfos  ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
