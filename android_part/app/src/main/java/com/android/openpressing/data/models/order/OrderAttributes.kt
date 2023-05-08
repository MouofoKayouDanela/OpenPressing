package com.android.openpressing.data.models.order

import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.message.Message
import com.google.gson.annotations.SerializedName

data class OrderAttributes(
    @SerializedName("Description") var description: String ,
    @SerializedName("PaymentAddress") var payment_address : String ,
    var message: Message ,
    var pickup_address: Quarter ,
    var delivery_address: Quarter ,
    var confirmed: Boolean ,
    var blocked: Boolean
)
