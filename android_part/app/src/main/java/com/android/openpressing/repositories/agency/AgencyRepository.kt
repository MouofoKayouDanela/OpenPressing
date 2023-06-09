package com.android.openpressing.repositories.agency

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.agency.AgencyData
import javax.inject.Inject

class AgencyRepository @Inject constructor(
    private val agencyApi : OpenPressingStrapiApi.AgencyApi
){
    suspend fun getAll() : MutableList<AgencyData> = agencyApi.getAll().data

    suspend fun getById(id: Int) : Agency=agencyApi.getById(id)

    suspend fun save(agency : Agency) = agencyApi.save(agency)

    suspend fun update(id : Int,agency : Agency) : Agency= agencyApi.update(id, agency)

    suspend fun delete(id : Int){
        val deletingAgency = getById(id)
        deletingAgency.data.attributes.confirmed = false

        update(id,deletingAgency)
    }
}