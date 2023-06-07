package com.android.openpressing.data.models.quarter

import android.os.Parcelable
import com.android.openpressing.data.models.agency.Agencies
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.city.City
import com.android.openpressing.data.models.order.Orders
import com.android.openpressing.data.models.user.Users
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
data class QuarterAttributes(
    @SerializedName("Name") var name: String ,
    var city: City ,
    var users: Users ,
    var agencies: Agencies? = null ,
    var orders: Orders? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
):Parcelable
