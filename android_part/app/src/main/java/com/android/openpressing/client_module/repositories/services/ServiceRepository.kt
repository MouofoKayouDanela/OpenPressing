package com.android.openpressing.client_module.repositories.services

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.Service
import javax.inject.Inject

class ServiceRepository @Inject constructor(
    private val serviceApi: OpenPressingStrapiApi.ServiceApi
    ) {

    suspend fun getAll() : List<Service> = serviceApi.getAll()

    suspend fun getById(id: Int) : Service = serviceApi.getById(id)

}