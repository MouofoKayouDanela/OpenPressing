package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.service.ServiceData

sealed class ServicesStates{

    object Empty:ServicesStates ()
    object  Loading: ServicesStates ()
    sealed class Success : ServicesStates() {
        class  ServicesSuccess(val data: MutableList<ServiceData>): Success ()
        class ServiceSuccess(val data: Service) : Success()
    }
    class Error(val message: String): ServicesStates ()
}


