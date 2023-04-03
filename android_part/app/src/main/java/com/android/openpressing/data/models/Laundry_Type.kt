package com.android.openpressing.data.models

data class Laundry_Type(
    var id: Int,
    var laundries: MutableList<Laundry>,
    var confirmed: Boolean,
    var blocked: Boolean,
)
