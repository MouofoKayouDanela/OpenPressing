package com.android.openpressing.repositories.laundry.city

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.city.City
import com.android.openpressing.data.models.city.CityData
import javax.inject.Inject

class CityRepository @Inject constructor(
    private val cityApi : OpenPressingStrapiApi.CityApi
) {
    suspend fun getAll() : MutableList<CityData> = cityApi.getAll().data

    suspend fun getById(id:Int) : City= cityApi.getById(id)

    suspend fun save(city : City) = cityApi.save(city)

    suspend fun update(id : Int,city : City) : City= cityApi.update(id, city)

    suspend fun delete(id : Int){
        val deletingCity = getById(id)
        deletingCity.data.attributes.confirmed=false

        update(id, deletingCity )
    }

}