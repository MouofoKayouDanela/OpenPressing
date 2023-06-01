package com.android.openpressing.data.models.utils

import android.os.Parcelable
import com.android.openpressing.data.models.quarter.Quarter
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfos(
    val nom : String,
    val prenom : String,
    val quarter : Quarter,
): Parcelable
