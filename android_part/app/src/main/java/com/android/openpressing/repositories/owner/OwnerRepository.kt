package com.android.openpressing.repositories.owner

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.owner.Owner
import com.android.openpressing.data.models.owner.OwnerData
import javax.inject.Inject

class OwnerRepository @Inject constructor(
    private val ownerApi : OpenPressingStrapiApi.OwnerApi
) {
    suspend fun getAll() : MutableList<OwnerData> = ownerApi.getAll().data

    suspend fun getById(id: Int) : Owner = ownerApi.getById(id)

    suspend fun save(owner : Owner) = ownerApi.save(owner)

    suspend fun update(id: Int,owner : Owner) : Owner = ownerApi.update(id , owner)

    suspend fun delete(id: Int) {

        val deletingOwner = getById(id)
            //deletingOwner.data.attributes.confirmed = false

        update(id, deletingOwner)
    }
}