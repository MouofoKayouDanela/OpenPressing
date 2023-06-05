package com.android.openpressing.repositories.agency_laundry

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.agency_laundry.AgencyLaundry
import com.android.openpressing.data.models.agency_laundry.AgencyLaundryData
import com.android.openpressing.data.models.agency_laundry.AgencyLaundryInfo
import com.android.openpressing.data.models.agency_laundry.AgencyLaundryInfoData
import retrofit2.Response
import javax.inject.Inject

class AgencyLaundryRepository @Inject constructor(
    private val agencyLaundryApi : OpenPressingStrapiApi.AgencyLaundryApi
) {
    suspend fun getAll() : MutableList<AgencyLaundryData> = agencyLaundryApi.getAll().data

    suspend fun getById(id:Int) =agencyLaundryApi.getById(id)

    suspend fun save(
        agencyLaundry : AgencyLaundryInfo
    ) = agencyLaundryApi.save(agencyLaundry)

    suspend fun update(id : Int, agencyLaundry : AgencyLaundryInfo) = agencyLaundryApi.update(id , agencyLaundry)

    suspend fun delete(id : Int) : Response<AgencyLaundryInfo> {

        val deletingAgencyLaundry=getById(id)

        return update(
                id = id,
                agencyLaundry = AgencyLaundryInfo(
                        AgencyLaundryInfoData(
                                id = deletingAgencyLaundry.data.id,
                                laundry = deletingAgencyLaundry.data.attributes.laundry.data.id!!,
                                agency = deletingAgencyLaundry.data.attributes.agency.data.id!!,
                                confirmed = false
                        )
                )
        )
    }
}