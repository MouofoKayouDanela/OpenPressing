package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.agency.AgencyData
import com.android.openpressing.data.models.pressing.PressingData

sealed class AgencyState{

    object Empty: AgencyState()
    object  Loading: AgencyState()
    class  Success(val data: MutableList<AgencyData >): AgencyState()
    class Error(val message: String): AgencyState()
}


