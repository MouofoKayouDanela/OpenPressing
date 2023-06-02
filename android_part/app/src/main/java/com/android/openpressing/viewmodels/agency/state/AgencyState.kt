package com.android.openpressing.viewmodels.agency.state

import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.agency.AgencyData


sealed class AgencyState{

    object Empty: AgencyState()
    object  Loading: AgencyState()
    sealed class Success : AgencyState(){
        class  AgenciesSuccess(val data: MutableList<AgencyData>): Success()
        class AgencySuccess(val data : Agency) : Success()
    }

    class Error(val message: String): AgencyState()
}

