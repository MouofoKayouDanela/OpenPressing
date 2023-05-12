package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.requirement.RequirementData
import com.android.openpressing.data.models.service.ServiceData

sealed class RequirementState{

    object Empty:RequirementState ()
    object  Loading: RequirementState ()
    class  Success(val data: MutableList<RequirementData>): RequirementState ()
    class Error(val message: String): RequirementState ()
}


