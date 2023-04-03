package com.android.openpressing.data.models

data class Agency(
    var id: Int ,
    val pressing: Pressing ,
    val quarter: Quarter ,
    var agent: MutableList<Agent> ,
    var agency_services: MutableList<Agency_Service> ,
    var agency_laundries: MutableList<Agency_Laundry> ,
    var confirmed: Boolean ,
    var blocked: Boolean
)