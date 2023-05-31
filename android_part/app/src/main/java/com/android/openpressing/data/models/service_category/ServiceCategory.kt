package com.android.openpressing.data.models.service_category

import android.os.Parcelable
import com.android.openpressing.data.models.service.Service
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ServiceCategory (
    var data: ServiceCategoryData
):Parcelable

