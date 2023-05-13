package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.laundry.LaundryData

sealed class LaundryState{

    object Empty: LaundryState()
    object  Loading: LaundryState()
    class  Success(val data: MutableList<LaundryData>): LaundryState()
    class Error(val message: String): LaundryState()
}


