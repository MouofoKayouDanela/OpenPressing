package com.android.openpressing.data.models.requirement

import android.os.Parcelable
import com.android.openpressing.data.models.client.Client
import com.android.openpressing.data.models.requirement_detail.RequirementDetail
import com.android.openpressing.data.models.message.Messages
import com.android.openpressing.data.models.requirement_detail.RequirementDetails
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
data class RequirementAttributes(
    var requirement_details: RequirementDetails ,
    var messages: Messages? = null ,
    var client: Client ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false ,
    val createdAt: Date = Date(),
    var updatedAt: Date = Date(),
    var publishedAt: Date = Date(),
):Parcelable
