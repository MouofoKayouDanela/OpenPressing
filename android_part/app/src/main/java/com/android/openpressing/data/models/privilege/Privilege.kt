package com.android.openpressing.data.models.privilege

import android.os.Parcelable
import com.android.openpressing.data.models.agent.Agent
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Privilege (
    var data: PrivilegeData
):Parcelable
