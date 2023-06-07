package com.android.openpressing.data.models.service

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Services(
    val data: MutableList<ServiceData>
):Parcelable
