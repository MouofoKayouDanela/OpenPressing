package com.android.openpressing.data.models.service_category

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ServiceCategoryData(
    var id: Int? = null,
    var attributes: ServiceCategoryAttributes
):Parcelable
