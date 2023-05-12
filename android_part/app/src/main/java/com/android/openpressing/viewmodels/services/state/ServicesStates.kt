package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.service.ServiceData

sealed class ServicesStates{

    object Empty: PromotionState()
    object  Loading: PromotionState()
    class  Success(val data: MutableList<ServiceData>): PromotionState()
    class Error(val message: String): PromotionState()
}


