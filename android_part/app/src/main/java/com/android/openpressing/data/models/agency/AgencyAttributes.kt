package com.android.openpressing.data.models.agency

import com.android.openpressing.data.models.agency_laundry.AgencyLaundries
import com.android.openpressing.data.models.agency_laundry.AgencyLaundry
import com.android.openpressing.data.models.agency_service.AgencyService
import com.android.openpressing.data.models.agency_service.AgencyServices
import com.android.openpressing.data.models.agent.Agent
import com.android.openpressing.data.models.agent.Agents
import com.android.openpressing.data.models.message.Messages
import com.android.openpressing.data.models.pressing.Pressing
import com.android.openpressing.data.models.quarter.Quarter

data class AgencyAttributes(
    val pressing: Pressing ,
    val quarter: Quarter ,
    var agents: Agents ,
    var messages: Messages ,
    var agency_services: AgencyServices ,
    var agency_laundries: AgencyLaundries ,
    var confirmed: Boolean ,
    var blocked: Boolean
)