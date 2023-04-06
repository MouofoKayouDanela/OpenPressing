package com.android.openpressing.data.models

data class Agent (
    var id: Int,
    val user: User,
    var agency: Agency,
    var privilege: Privilege
)
