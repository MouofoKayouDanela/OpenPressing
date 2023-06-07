package com.android.openpressing.data.models.requirement

data class RequirementInfoData(
    var id: Int? = null,
    var client: Int,
    var requirement_details: List<Int>,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false ,
)