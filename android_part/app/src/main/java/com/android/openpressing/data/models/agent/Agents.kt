package com.android.openpressing.data.models.agent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Agents(
    var data: MutableList<AgentData>
):Parcelable
