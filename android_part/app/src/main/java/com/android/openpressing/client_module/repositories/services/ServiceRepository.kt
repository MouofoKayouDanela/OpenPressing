package com.android.openpressing.client_module.repositories.services

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.service.ServiceData
import javax.inject.Inject

class ServiceRepository @Inject constructor(
    private val serviceApi: OpenPressingStrapiApi.ServiceApi
    ) {

    suspend fun getAll() : MutableList<ServiceData> = serviceApi.getAll().data

    suspend fun getById(id: Int) : Service = serviceApi.getById(id)

}