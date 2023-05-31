package com.android.openpressing.data.models.requirement

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class RequirementData(
    var id: Int? = null ,
    var attributes: RequirementAttributes
):Parcelable
