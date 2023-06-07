package com.android.openpressing.data.models.utils

import android.net.Uri
import android.os.Parcelable
import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.quarter.QuarterInfos
import com.android.openpressing.data.models.utils.images.ImageInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfos(
    val nom : String,
    val prenom : String,
    val imageInfo : ImageInfo?,
    val imageUri: Uri?,
    val quarterInfos : QuarterInfos,
): Parcelable
