package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.pressing.PressingData

sealed class PressingState{

    object Empty: PromotionState()
    object  Loading: PromotionState()
    class  Success(val data: MutableList<PressingData>): PromotionState()
    class Error(val message: String): PromotionState()
}


