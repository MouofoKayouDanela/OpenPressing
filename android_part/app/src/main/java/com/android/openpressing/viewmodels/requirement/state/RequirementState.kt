package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.requirement.Requirement
import com.android.openpressing.data.models.requirement.RequirementData
import com.android.openpressing.data.models.service.ServiceData

sealed class RequirementState{

    object Empty:RequirementState ()
    object  Loading: RequirementState ()
    sealed class Success : RequirementState() {
        data class  RequirementsSuccess(val data: MutableList<RequirementData>): Success ()
        data class  RequirementSuccess(val data: Requirement): Success ()
        data class Save(val result: Boolean) : Success()
        data class Delete(val result: Boolean): Success()
    }
    class Error(val message: String): RequirementState ()
}


