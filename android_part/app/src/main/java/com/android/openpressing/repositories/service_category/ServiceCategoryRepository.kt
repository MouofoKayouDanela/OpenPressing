package com.android.openpressing.repositories.service_category

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.service_category.ServiceCategory
import com.android.openpressing.data.models.service_category.ServiceCategoryData

import javax.inject.Inject

class ServiceCategoryRepository @Inject constructor(
    private val serviceCategoryApi : OpenPressingStrapiApi.ServiceCategoryApi
) {
    suspend fun getAll() : MutableList<ServiceCategoryData> = serviceCategoryApi.getAll().data

    suspend fun getById(id: Int) : ServiceCategory = serviceCategoryApi.getById(id)

    suspend fun save(serviceCategory : ServiceCategory) = serviceCategoryApi.save(serviceCategory)

    suspend fun update(id: Int,serviceCategory : ServiceCategory) : ServiceCategory = serviceCategoryApi.update(id, serviceCategory)

    suspend fun delete(id: Int) {

        val deletingServiceCategory = getById(id)
        deletingServiceCategory.data.attributes.confirmed=false

        update(id, deletingServiceCategory)
    }
}