package com.android.openpressing.repositories.agency_service

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.agency_service.AgencyService
import com.android.openpressing.data.models.agency_service.AgencyServiceData
import javax.inject.Inject

class AgencyServiceRepository @Inject constructor(
    private val agencyServiceApi : OpenPressingStrapiApi.AgencyServiceApi
) {
    suspend fun getAll() : MutableList<AgencyServiceData> = agencyServiceApi.getAll().data

    suspend fun getById(id:Int) : AgencyService = agencyServiceApi.getById(id)

    suspend fun save(agencyService : AgencyService) = agencyServiceApi.save(agencyService)

    suspend fun update(id : Int,agencyService : AgencyService) : AgencyService = agencyServiceApi.update(id, agencyService)

    suspend fun delete(id : Int){
        val deletingAgencyService = getById(id)
        deletingAgencyService.data.attributes.confirmed=false

        update(id, deletingAgencyService )
    }

}