package com.android.openpressing.data.models

import java.util.Date

data class Owner(
    var id: Int,
    val user: User,
    var pressings: MutableList<Pressing>
)
