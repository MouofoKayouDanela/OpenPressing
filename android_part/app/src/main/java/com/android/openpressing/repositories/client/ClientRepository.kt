package com.android.openpressing.repositories.client

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.city.City
import com.android.openpressing.data.models.city.CityData
import com.android.openpressing.data.models.client.Client
import com.android.openpressing.data.models.client.ClientData
import javax.inject.Inject

class ClientRepository @Inject constructor(
    private val clientApi : OpenPressingStrapiApi.ClientApi
) {
    suspend fun getAll() : MutableList<ClientData> = clientApi.getAll().data

    suspend fun getById(id:Int) : Client = clientApi.getById(id)

    suspend fun save(client : Client) = clientApi.save(client)


    suspend fun update(id : Int,client : Client) : Client = clientApi.update(id, client)

    /*suspend fun delete(id : Int){
        val deletingClient = getById(id)
        deletingClient .data.attributes.

        update()
    }*/
}