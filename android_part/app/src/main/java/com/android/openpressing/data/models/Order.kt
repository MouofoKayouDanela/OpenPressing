package com.android.openpressing.data.models

import com.google.gson.annotations.SerializedName

data class Order(
    var id: Int ,
    @SerializedName("Description") var description: String ,
    @SerializedName("PayementAddress") var payementAdress : String ,
    var message: Message ,
    var pickup_address: Quarter ,
    var delivery_address: Quarter ,
    var confirmed: Boolean ,
    var blocked: Boolean
)
