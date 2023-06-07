package com.android.openpressing.data.models.agency

import android.os.Parcelable
import com.android.openpressing.data.models.agency_laundry.AgencyLaundries
import com.android.openpressing.data.models.agency_laundry.AgencyLaundry
import com.android.openpressing.data.models.agency_service.AgencyService
import com.android.openpressing.data.models.agency_service.AgencyServices
import com.android.openpressing.data.models.agent.Agent
import com.android.openpressing.data.models.agent.Agents
import com.android.openpressing.data.models.message.Messages
import com.android.openpressing.data.models.pressing.Pressing
import com.android.openpressing.data.models.quarter.Quarter
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class AgencyAttributes(
    val pressing: Pressing ,
    val quarter: Quarter ,
    var agents: Agents? = null ,
    var messages: Messages? = null ,
    var agency_services: AgencyServices? = null ,
    var agency_laundries: AgencyLaundries? = null ,
    var createdAt: Date = Date() ,
    var updatedAt: Date = Date() ,
    var publishedAt: Date = Date() ,
    var confirmed: Boolean = true ,
    var blocked: Boolean = false
):Parcelable