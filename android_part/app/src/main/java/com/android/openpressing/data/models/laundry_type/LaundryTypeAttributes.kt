package com.android.openpressing.data.models.laundry_type

import com.android.openpressing.data.models.laundry.Laundries

data class LaundryTypeAttributes(
    var laundries: Laundries? = null ,
    var confirmed: Boolean = true,
    var blocked: Boolean = false ,
)
