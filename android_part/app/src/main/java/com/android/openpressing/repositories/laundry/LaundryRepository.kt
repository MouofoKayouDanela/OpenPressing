package com.android.openpressing.repositories.laundry

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.laundry_category.laundry.Laundry
import com.android.openpressing.data.models.laundry_category.laundry.LaundryData
import javax.inject.Inject

class LaundryRepository @Inject constructor(
    private val laundryApi : OpenPressingStrapiApi.LaundryApi
) {
    suspend fun getAll() : MutableList<LaundryData> = laundryApi.getAll().data

    suspend fun getById(id:Int) = laundryApi.getById(id)

    suspend fun save(laundry : Laundry) = laundryApi.save(laundry)

    suspend fun update(id : Int,laundry : Laundry) : Laundry = laundryApi.update(id, laundry)

    suspend fun delete(id : Int){
        val deletingLaundry = getById(id)
        deletingLaundry.data.attributes.confirmed=false

        update(id, deletingLaundry )
    }
}