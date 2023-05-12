package com.android.openpressing.repositories.quarter

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.quarter.QuarterData

import javax.inject.Inject

class QuarterRepository @Inject constructor(
    private val quarterApi : OpenPressingStrapiApi.QuarterApi
) {
    suspend fun getAll() : MutableList<QuarterData> = quarterApi.getAll().data

    suspend fun getById(id: Int) : Quarter= quarterApi.getById(id)

    suspend fun save(quarter : Quarter) = quarterApi.save(quarter)

    suspend fun update(id: Int,quarter : Quarter) : Quarter = quarterApi.update(id, quarter)

    suspend fun delete(id: Int) {

        val deletingQuarter = getById(id)
        //deletingQuarter.data.attributes.confirmed = false

        update(id, deletingQuarter)
    }
}