package com.android.openpressing.viewmodels.agency_service

import androidx.lifecycle.ViewModel
import com.android.openpressing.data.models.agency_service.AgencyService
import com.android.openpressing.data.models.agency_service.AgencyServiceData
import com.android.openpressing.repositories.agency_service.AgencyServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class AgencyServiceViewModel @Inject constructor(
    private val repository: AgencyServiceRepository
) : ViewModel() {

    fun findAll() : Flow<List<AgencyServiceData>> = flow {
        emit(repository.getAll())
    }.flowOn(Dispatchers.IO)

    fun save(agencyService: AgencyService) = flow {
        emit(repository.save(agencyService))
    }.flowOn(Dispatchers.IO)
}