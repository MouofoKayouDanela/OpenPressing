package com.android.openpressing.data.models.service_type

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class ServiceTypeData(
    var id: Int? = null,
    var attributes: ServiceTypeAttributes
):Parcelable
