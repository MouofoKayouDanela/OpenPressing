package com.android.openpressing.repositories.privilege

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.privilege.Privilege

import com.android.openpressing.data.models.privilege.PrivilegeData
import javax.inject.Inject

class PrivilegeRepository @Inject constructor(
    private val privilegeApi : OpenPressingStrapiApi.PrivilegeApi
) {
    suspend fun getAll() : MutableList<PrivilegeData> = privilegeApi.getAll().data

    suspend fun getById(id: Int) : Privilege = privilegeApi.getById(id)

    suspend fun save(privilege : Privilege) = privilegeApi.save(privilege)

    suspend fun update(id: Int,privilege : Privilege) : Privilege = privilegeApi.update(id , privilege)

    suspend fun delete(id: Int) {

        val deletingPrivilege = getById(id)
        deletingPrivilege.data.attributes.confirmed = false

        update(id, deletingPrivilege)
    }
}