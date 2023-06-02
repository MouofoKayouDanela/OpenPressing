package com.android.openpressing.repositories.service_type

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.service_type.ServiceType
import com.android.openpressing.data.models.service_type.ServiceTypeData
import javax.inject.Inject

class ServiceTypeRepository @Inject constructor(
    private val serviceTypeApi : OpenPressingStrapiApi.ServiceTypeApi
) {
    suspend fun getAll() : MutableList<ServiceTypeData> = serviceTypeApi.getAll().data

    suspend fun getById(id: Int) : ServiceType = serviceTypeApi.getById(id)

    suspend fun save(serviceType : ServiceType) = serviceTypeApi.save(serviceType)

    suspend fun update(id: Int,serviceType : ServiceType) : ServiceType = serviceTypeApi.update(id , serviceType)

    suspend fun delete(id: Int) {

        val deletingServiceType = getById(id)
        deletingServiceType.data.attributes.confirmed=false

        update(id, deletingServiceType)
    }

}