package com.android.openpressing.data.models.laundry_type

import com.android.openpressing.data.models.laundry.Laundries

data class LaundryTypeAttributes(
    var laundries: Laundries ,
    var confirmed: Boolean ,
    var blocked: Boolean ,
)
