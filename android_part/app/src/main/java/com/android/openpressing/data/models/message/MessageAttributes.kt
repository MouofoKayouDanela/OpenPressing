package com.android.openpressing.data.models.message

import android.os.Parcelable
import com.android.openpressing.data.models.order.Order
import com.android.openpressing.data.models.requirement.Requirement
import com.android.openpressing.data.models.agency.Agency
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
data class MessageAttributes(
    var creationDate: Date ,
    @SerializedName("Description") var description: String ,
    var agency: Agency ,
    var requirement: Requirement ,
    var order: Order ,
    var createdAt: Date = Date(),
    var updatedAt: Date = Date(),
    var publishedAt: Date = Date(),
    var confirmed: Boolean = true,
    var blocked: Boolean = false
):Parcelable
