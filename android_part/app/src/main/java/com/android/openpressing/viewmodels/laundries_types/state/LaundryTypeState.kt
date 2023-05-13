package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.laundry_type.LaundryTypeData
import com.android.openpressing.data.models.pressing.PressingData

sealed class LaundryTypeState{

    object Empty: LaundryTypeState()
    object  Loading: LaundryTypeState()
    class  Success(val data: MutableList<LaundryTypeData>): LaundryTypeState()
    class Error(val message: String): LaundryTypeState()
}


