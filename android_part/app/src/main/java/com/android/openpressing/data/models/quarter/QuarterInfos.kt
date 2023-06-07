package com.android.openpressing.data.models.quarter

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class QuarterInfos (
    var id: Int? = null,
    var createdAt: Date = Date(),
    var updatedAt: Date = Date(),
    var publishedAt: Date = Date(),
    @SerializedName("Name") var name: String,
 ):Parcelable
