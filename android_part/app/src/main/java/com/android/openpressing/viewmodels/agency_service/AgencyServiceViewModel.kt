package com.android.openpressing.viewmodels.agency_service

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.agency_service.AgencyService
import com.android.openpressing.data.models.agency_service.AgencyServiceData
import com.android.openpressing.data.models.agency_service.AgencyServiceInfo
import com.android.openpressing.repositories.agency_service.AgencyServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgencyServiceViewModel @Inject constructor(
    private val repository: AgencyServiceRepository
) : ViewModel() {

    fun findAll() : Flow<List<AgencyServiceData>> = flow {
        emit(repository.getAll())
    }.flowOn(Dispatchers.IO)

    fun save(agencyService: AgencyServiceInfo) {
        viewModelScope.launch {
            repository.save(agencyService)
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch {
            repository.delete(id)
        }
    }

}