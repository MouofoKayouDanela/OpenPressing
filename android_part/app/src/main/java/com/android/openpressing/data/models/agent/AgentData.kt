package com.android.openpressing.data.models.agent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class AgentData(
    var id: Int? = null ,
    var agentAttributes: AgentAttributes
):Parcelable
