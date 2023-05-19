package com.android.openpressing.repositories.pressing

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.pressing.Pressing
import com.android.openpressing.data.models.pressing.PressingData


import javax.inject.Inject

class PressingRepository @Inject constructor(
    private val pressingApi : OpenPressingStrapiApi.PressingApi
) {
    suspend fun getAll() : MutableList<PressingData> = pressingApi.getAll().data

    suspend fun getById(id: Int) : Pressing = pressingApi.getById(id)

    suspend fun save(pressing: Pressing) = pressingApi.save(pressing)

    suspend fun update(id: Int,pressing: Pressing) : Pressing = pressingApi.update(id, pressing)

    suspend fun delete(id: Int) {

        val deletingPressing = getById(id)
        deletingPressing.data.attributes.confirmed = false

        update(id, deletingPressing)
    }
}