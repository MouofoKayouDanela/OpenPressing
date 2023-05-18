package com.android.openpressing.viewmodels.requirement_detail.state

import com.android.openpressing.data.models.requirement_detail.RequirementDetail


sealed class RequirementDetailState {

    object Empty : RequirementDetailState()

    object Loading : RequirementDetailState()

    data class Success(val requirementDetail: RequirementDetail) : RequirementDetailState()

    data class Error(val message: String) : RequirementDetailState()

}
