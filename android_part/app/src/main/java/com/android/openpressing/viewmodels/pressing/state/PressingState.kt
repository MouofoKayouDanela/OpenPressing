package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.pressing.PressingData

sealed class
PressingState{

    object Empty: PressingState()
    object  Loading: PressingState()
    class  Success(val data: MutableList<PressingData>): PressingState()
    class Error(val message: String): PressingState()
}


