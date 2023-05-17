package com.android.openpressing.viewmodels.quarter.state

import com.android.openpressing.data.models.quarter.QuarterData


sealed class QuarterState{

    object Empty: QuarterState()

    object  Loading: QuarterState()

    class  Success(val data: MutableList<QuarterData>): QuarterState()

    class Error(val message: String): QuarterState()
}