package com.android.openpressing.data.models.privilege

import com.android.openpressing.data.models.agent.Agents
import com.google.gson.annotations.SerializedName

data class PrivilegeAttributes(
    @SerializedName("Name") var name: String ,
    @SerializedName("Description") var description: String ,
    var agents: Agents ,
    var confirmed: Boolean ,
    var blocked: Boolean
)
