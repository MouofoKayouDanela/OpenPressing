package com.android.openpressing.viewmodels.agency_laundry

import androidx.lifecycle.ViewModel
import com.android.openpressing.data.models.agency_laundry.AgencyLaundry
import com.android.openpressing.data.models.agency_laundry.AgencyLaundryData
import com.android.openpressing.repositories.agency_laundry.AgencyLaundryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class AgencyLaundryViewModel @Inject constructor(
    private val repository: AgencyLaundryRepository
) : ViewModel() {

    fun findAll(): Flow<List<AgencyLaundryData>> = flow {
        emit(repository.getAll())
    }.flowOn(Dispatchers.IO)

    fun save(agencyLaundry: AgencyLaundry) = flow{
        emit(repository.save(agencyLaundry))
    }.flowOn(Dispatchers.IO)
}