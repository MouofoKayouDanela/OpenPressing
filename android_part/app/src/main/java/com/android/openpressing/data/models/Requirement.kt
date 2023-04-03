package com.android.openpressing.data.models

data class Requirement(
    val id: Int,
    var requirement_details: MutableList<Requirement_Detail>,
    var messages: MutableList<Message>,
    var confirmed: Boolean,
    var blocked: Boolean
)