package com.android.openpressing.repositories.agency_service

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.agency_service.AgencyService
import com.android.openpressing.data.models.agency_service.AgencyServiceData
import com.android.openpressing.data.models.agency_service.AgencyServiceInfo
import com.android.openpressing.data.models.agency_service.AgencyServiceInfoData
import javax.inject.Inject

class AgencyServiceRepository @Inject constructor(
    private val agencyServiceApi : OpenPressingStrapiApi.AgencyServiceApi
) {
    suspend fun getAll() : MutableList<AgencyServiceData> = agencyServiceApi.getAll().data

    suspend fun getById(id:Int) : AgencyService = agencyServiceApi.getById(id)

    suspend fun save(agencyService : AgencyServiceInfo) = agencyServiceApi.save(agencyService)

    suspend fun update(id : Int,agencyService : AgencyServiceInfo) = agencyServiceApi.update(id , agencyService)

    suspend fun delete(id : Int){
        val deletingAgencyService = getById(id)

        update(
                id = id,
                agencyService = AgencyServiceInfo(
                        AgencyServiceInfoData(
                                id = deletingAgencyService.data.id,
                                service = deletingAgencyService.data.attributes.service.data.id!!,
                                agency = deletingAgencyService.data.attributes.agency.data.id!!,
                                confirmed = false
                        )
                )
        )
    }

}