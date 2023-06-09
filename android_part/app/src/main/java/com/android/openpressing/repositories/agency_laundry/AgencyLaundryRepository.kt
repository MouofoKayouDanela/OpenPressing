package com.android.openpressing.repositories.agency_laundry

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.agency_laundry.AgencyLaundry
import com.android.openpressing.data.models.agency_laundry.AgencyLaundryData
import javax.inject.Inject

class AgencyLaundryRepository @Inject constructor(
    private val agencyLaundryApi : OpenPressingStrapiApi.AgencyLaundryApi
) {
    suspend fun getAll() : MutableList<AgencyLaundryData> = agencyLaundryApi.getAll().data

    suspend fun getById(id:Int) =agencyLaundryApi.getById(id)

    suspend fun save(agencyLaundry : AgencyLaundry) = agencyLaundryApi.save(agencyLaundry)

    suspend fun update(id : Int, agencyLaundry : AgencyLaundry) : AgencyLaundry=agencyLaundryApi.update(id, agencyLaundry)

    suspend fun delete(id : Int){
        val deletingAgencyLaundry=getById(id)
        deletingAgencyLaundry.data.attributes.confirmed=false

        update(id,deletingAgencyLaundry)
    }
}