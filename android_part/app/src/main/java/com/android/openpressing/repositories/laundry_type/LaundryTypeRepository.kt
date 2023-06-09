package com.android.openpressing.repositories.laundry_type

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.laundry_type.LaundryType
import com.android.openpressing.data.models.laundry_type.LaundryTypeData
import javax.inject.Inject

class LaundryTypeRepository @Inject constructor(
    private val laundryTypeApi : OpenPressingStrapiApi.LaundryTypeApi
) {
    suspend fun getAll() : MutableList<LaundryTypeData> = laundryTypeApi.getAll().data

    suspend fun getById(id: Int)  = laundryTypeApi.getById(id)

    suspend fun save(laundryType : LaundryType) =laundryTypeApi.save(laundryType)

    suspend fun update(id : Int, laundryType:LaundryType) : LaundryType =laundryTypeApi.update(id, laundryType)

     suspend fun delete(id : Int){
         val deletingLaundryType = getById(id)
         deletingLaundryType.data.attributes.confirmed=false

         update(id, deletingLaundryType)
     }
}