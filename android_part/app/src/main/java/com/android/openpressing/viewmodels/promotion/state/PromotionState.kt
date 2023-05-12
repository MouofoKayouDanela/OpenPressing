package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.pressing.PressingData
import com.android.openpressing.data.models.promotion.PromotionData

sealed class PromotionState{

    object Empty: PromotionState()
    object  Loading: PromotionState()
    class  Success(val data: MutableList<PromotionData>): PromotionState()
    class Error(val message: String): PromotionState()
}


