package com.android.openpressing.repositories.administrator

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.administrator.Administrator
import com.android.openpressing.data.models.administrator.AdministratorData
import javax.inject.Inject

class AdministratorRepository @Inject constructor(
    private val administratorApi : OpenPressingStrapiApi.AdministratorApi
){
    suspend fun getAll() : MutableList<AdministratorData> = administratorApi.getAll().data

    suspend fun getById(id: Int) : Administrator = administratorApi.getById(id)

    suspend fun save(administrator : Administrator) =administratorApi.save(administrator)

    suspend fun update(id : Int, administrator : Administrator) : Administrator =administratorApi.update(id , administrator)

   /* suspend fun delete(id : Int){
        val deletingAdministrator = getById(id)
        deletingAdministrator.data.attributes.
    }*/
}