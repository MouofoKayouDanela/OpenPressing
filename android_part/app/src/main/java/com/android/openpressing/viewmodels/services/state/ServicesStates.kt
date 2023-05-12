package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.service.ServiceData

sealed class ServicesStates{

    object Empty:ServicesStates ()
    object  Loading: ServicesStates ()
    class  Success(val data: MutableList<ServiceData>): ServicesStates ()
    class Error(val message: String): ServicesStates ()
}


