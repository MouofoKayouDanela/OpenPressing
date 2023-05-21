package com.android.openpressing.viewmodels.requirement_detail.state

import com.android.openpressing.data.models.requirement_detail.RequirementDetail
import com.android.openpressing.data.models.requirement_detail.RequirementDetailData


sealed class RequirementDetailState {

    object Empty : RequirementDetailState()

    object Loading : RequirementDetailState()

    sealed class Success : RequirementDetailState() {
        data class RdSuccess(val requirementDetail: RequirementDetail) : Success()
        data class RdsSuccess(val requirementDetails: MutableList<RequirementDetailData>) : Success()
    }

    data class Error(val message: String) : RequirementDetailState()

}
