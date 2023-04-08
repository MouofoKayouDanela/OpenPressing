package com.android.openpressing.data.models

import android.media.Image

data class Laundry (
    var id: Int ,
    var categorie: Laundry_Category ,
    var type: Laundry_Type ,
    var agency_laundries: MutableList<Agency_Laundry> ,
    var requirement_details: Requirement_Detail ,
    var laundryImage: Image ,
    var confirmed: Boolean ,
    var blocked: Boolean
)
