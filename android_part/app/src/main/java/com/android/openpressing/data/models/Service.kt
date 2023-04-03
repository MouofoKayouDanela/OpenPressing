package com.android.openpressing.data.models

import android.media.Image

data class Service(
    var id: Int ,
    var category: Service_Category ,
    var type: Service_Type ,
    var agency_services: MutableList<Agency_Service> ,
    var serviceImage: Image ,
    var confirmed: Boolean ,
    var blocked: Boolean
)
