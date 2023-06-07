package com.android.openpressing.data.models.privilege

import android.os.Parcelable
import com.android.openpressing.data.models.agent.Agents
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*
@Parcelize
data class PrivilegeAttributes(
    @SerializedName("Name") var name: String ,
    @SerializedName("Description") var description: String ,
    var agents: Agents? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
):Parcelable
