package com.android.openpressing.viewmodels.agency_service

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.agency_service.AgencyService
import com.android.openpressing.data.models.agency_service.AgencyServiceData
import com.android.openpressing.data.models.agency_service.AgencyServiceInfo
import com.android.openpressing.repositories.agency_service.AgencyServiceRepository
import com.android.openpressing.viewmodels.agency_service.state.AgencyServiceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgencyServiceViewModel @Inject constructor(
    private val repository: AgencyServiceRepository
) : ViewModel() {

    private val _agencyServiceState = MutableStateFlow<AgencyServiceState>(AgencyServiceState.Empty)
    val agencyServiceState = _agencyServiceState.asStateFlow()

    fun findAll() : Flow<List<AgencyServiceData>> = flow {
        emit(repository.getAll())
    }.flowOn(Dispatchers.IO)

    fun save(agencyService: AgencyServiceInfo) {
        _agencyServiceState.value = AgencyServiceState.Loading
        viewModelScope.launch {
             val response = repository.save(agencyService)
            _agencyServiceState.value = AgencyServiceState.Success.Save(response.isSuccessful)
        }
    }

//    fun delete(id: Int) {
//        _agencyServiceState.value = AgencyServiceState.Loading
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = repository.delete(id)
//            _agencyServiceState.value = AgencyServiceState.Success.Delete(response.isSuccessful)
//        }
//    }

    fun delete(id: Int) = flow {
        emit(repository.delete(id))
    }.flowOn(Dispatchers.IO)

}