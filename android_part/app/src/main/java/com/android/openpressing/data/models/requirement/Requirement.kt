package com.android.openpressing.data.models.requirement

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Requirement(
    var data: RequirementData
):Parcelable