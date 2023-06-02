package com.android.openpressing.viewmodels.agency_laundry

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.agency_laundry.AgencyLaundryData
import com.android.openpressing.data.models.agency_laundry.AgencyLaundryInfo
import com.android.openpressing.repositories.agency_laundry.AgencyLaundryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgencyLaundryViewModel @Inject constructor(
    private val repository: AgencyLaundryRepository
) : ViewModel() {

    fun findAll(): Flow<List<AgencyLaundryData>> = flow {
        emit(repository.getAll())
    }.flowOn(Dispatchers.IO)

    fun save(agencyLaundry: AgencyLaundryInfo) {
        viewModelScope.launch {
            repository.save(agencyLaundry)
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch {
            repository.delete(id)
        }
    }
}