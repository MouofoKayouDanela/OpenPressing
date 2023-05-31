package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.laundry_category.laundry.Laundry
import com.android.openpressing.data.models.laundry_category.laundry.LaundryData
import com.android.openpressing.data.models.pressing.Pressing
import com.android.openpressing.data.models.pressing.PressingData

sealed class PressingState{

    object Empty: PressingState()
    object  Loading: PressingState()

    sealed class Success: PressingState(){
        class  PressingsSuccess(val data: MutableList<PressingData>): Success()

        class PressingSuccess(val data: Pressing) : Success()

    }

    class Error(val message: String): PressingState()
}



