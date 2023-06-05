package com.android.openpressing.viewmodels.agency_laundry

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.agency_laundry.AgencyLaundryData
import com.android.openpressing.data.models.agency_laundry.AgencyLaundryInfo
import com.android.openpressing.repositories.agency_laundry.AgencyLaundryRepository
import com.android.openpressing.viewmodels.agency_laundry.state.AgencyLaundryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgencyLaundryViewModel @Inject constructor(
    private val repository: AgencyLaundryRepository
) : ViewModel() {

    private val _agencyLaundryState = MutableStateFlow<AgencyLaundryState>(AgencyLaundryState.Empty)
    val agencyLaundryState = _agencyLaundryState.asStateFlow()

    fun findAll(): Flow<List<AgencyLaundryData>> = flow {
        emit(repository.getAll())
    }.flowOn(Dispatchers.IO)

    fun save(agencyLaundry: AgencyLaundryInfo) {
        _agencyLaundryState.value = AgencyLaundryState.Loading
        viewModelScope.launch {
            val response = repository.save(agencyLaundry)
            _agencyLaundryState.value = AgencyLaundryState.Success.Save(response.isSuccessful)
        }
    }

    fun delete(id: Int) = flow {
        emit(repository.delete(id))
    }.flowOn(Dispatchers.IO)

//    fun delete(id: Int) {
//        _agencyLaundryState.value = AgencyLaundryState.Loading
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = repository.delete(id)
//            _agencyLaundryState.value = AgencyLaundryState.Success.Delete(response.isSuccessful)
//        }
//    }
}