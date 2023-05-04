package com.android.openpressing.data.models.requirement

import com.android.openpressing.data.models.client.Client
import com.android.openpressing.data.models.requirement_detail.RequirementDetail
import com.android.openpressing.data.models.message.Messages
import com.android.openpressing.data.models.requirement_detail.RequirementDetails

data class RequirementAttributes(
    var requirement_details: RequirementDetails ,
    var messages: Messages ,
    var client: Client ,
    var confirmed: Boolean ,
    var blocked: Boolean
)
