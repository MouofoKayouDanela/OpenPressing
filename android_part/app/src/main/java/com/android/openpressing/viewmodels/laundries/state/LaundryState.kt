package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.laundry_category.laundry.Laundry
import com.android.openpressing.data.models.laundry_category.laundry.LaundryData

sealed class LaundryState{

    object Empty: LaundryState()
    object  Loading: LaundryState()
    sealed class Success : LaundryState() {
        class  LaundriesSuccess(val data: MutableList<LaundryData>): Success()
        
        class LaundrySuccess(val data: Laundry) : Success()
    }
    class Error(val message: String): LaundryState()
}


