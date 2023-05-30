package com.android.openpressing.viewmodels.quarter.state

import com.android.openpressing.data.models.laundry_category.laundry.Laundry
import com.android.openpressing.data.models.laundry_category.laundry.LaundryData
import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.quarter.QuarterData
import com.android.openpressing.viewmodels.services.state.LaundryState


sealed class QuarterState{

    object Empty: QuarterState()

    object  Loading: QuarterState()

    sealed class Success : QuarterState(){
        class  QuartersSuccess(val data: MutableList<QuarterData>): Success()

        class  QuarterSuccess(val data: Quarter): Success()
    }

    class Error(val message: String): QuarterState()
}
