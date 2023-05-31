package com.android.openpressing.data.models.service

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class ServiceData(
    var id: Int? = null ,
    var attributes: ServiceAttributes
):Parcelable
