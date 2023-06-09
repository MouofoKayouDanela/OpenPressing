package com.android.openpressing.viewmodels.city

import androidx.lifecycle.ViewModel
import com.android.openpressing.data.models.city.City
import com.android.openpressing.data.models.city.CityData
import com.android.openpressing.data.models.client.Client
import com.android.openpressing.data.models.client.ClientData
import com.android.openpressing.repositories.laundry.city.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val cityRepository: CityRepository
): ViewModel() {

    fun getById(id: Int) : Flow<City> = flow {
        emit(cityRepository.getById(id))
    }.flowOn(Dispatchers.IO)


    fun findAll() : Flow<MutableList<CityData>> = flow {
        emit(cityRepository.getAll())
    }.flowOn(Dispatchers.IO)
}