package com.android.openpressing.repositories.laundry_category

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.laundry_category.LaundryCategory
import com.android.openpressing.data.models.laundry_category.LaundryCategoryData
import javax.inject.Inject

class LaundryCategoryRepository @Inject constructor(
    private val laundryCategoryApi : OpenPressingStrapiApi.LaundryCategoryApi
) {
    suspend fun getAll() : MutableList<LaundryCategoryData> = laundryCategoryApi.getAll().data

    suspend fun getById(id:Int)  = laundryCategoryApi.getById(id)

    suspend fun save(laundryCategory : LaundryCategory) = laundryCategoryApi.save(laundryCategory)

    suspend fun update(id : Int,laundryCategory : LaundryCategory) : LaundryCategory = laundryCategoryApi.update(id , laundryCategory)

    suspend fun delete(id : Int){
        val deletingLaundryCategory = getById(id)
        deletingLaundryCategory.data.attributes.confirmed=false

        update(id, deletingLaundryCategory )
    }
}