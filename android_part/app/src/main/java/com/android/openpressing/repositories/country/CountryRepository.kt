package com.android.openpressing.repositories.country

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.country.Country
import com.android.openpressing.data.models.country.CountryData
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val countryApi : OpenPressingStrapiApi.CountryApi
) {
    suspend fun getAll() : MutableList<CountryData> = countryApi.getAll().data

    suspend fun getById(id:Int) : Country = countryApi.getById(id)

    suspend fun save(country : Country) = countryApi.save(country)

    suspend fun update(id : Int,country : Country) : Country = countryApi.update(id, country)

    suspend fun delete(id : Int){
        val deletingCountry = getById(id)
        deletingCountry.data.attributes.confirmed=false

        update(id, deletingCountry )
    }
}