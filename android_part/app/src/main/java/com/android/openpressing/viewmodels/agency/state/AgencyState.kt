package com.android.openpressing.viewmodels.agency.state

import com.android.openpressing.data.models.agency.AgencyData


sealed class AgencyState{

    object Empty: AgencyState()
    object  Loading: AgencyState()
    class  Success(val data: MutableList<AgencyData>): AgencyState()
    class Error(val message: String): AgencyState()
}