package com.android.openpressing.data.models.requirement_detail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RequirementDetailData(
    var id: Int? = null,
    var attributes: RequirementDetailAttributes
):Parcelable
