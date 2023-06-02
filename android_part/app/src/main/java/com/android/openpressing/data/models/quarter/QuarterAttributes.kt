package com.android.openpressing.data.models.quarter

import com.android.openpressing.data.models.agency.Agencies
import com.android.openpressing.data.models.city.City
import com.android.openpressing.data.models.order.Orders
import com.android.openpressing.data.models.user.Users
import com.google.gson.annotations.SerializedName
import java.util.*

data class QuarterAttributes(
    @SerializedName("Name") var name: String ,
    var city: City ,
    var users: Users ,
    var agencies: Agencies? = null ,
    var orders: Orders? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
)
