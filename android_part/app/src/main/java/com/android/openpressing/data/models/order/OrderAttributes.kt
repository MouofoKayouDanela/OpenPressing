package com.android.openpressing.data.models.order

import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.message.Message
import com.google.gson.annotations.SerializedName
import java.util.*

data class OrderAttributes(
    @SerializedName("Description") var description: String ,
    @SerializedName("PaymentAddress") var payment_address : String ,
    var message: Message ,
    var pickup_address: Quarter ,
    var delivery_address: Quarter ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
)
