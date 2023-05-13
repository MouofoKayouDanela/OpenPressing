package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.offer.OfferData
import com.android.openpressing.data.models.pressing.PressingData

sealed class OfferState{

    object Empty: OfferState()
    object  Loading: OfferState()
    class  Success(val data: MutableList<OfferData>): OfferState()
    class Error(val message: String): OfferState()
}


