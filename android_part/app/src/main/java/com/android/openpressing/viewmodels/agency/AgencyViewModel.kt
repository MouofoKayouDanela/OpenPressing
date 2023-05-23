package com.android.openpressing.viewmodels.agency

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.repositories.agency.AgencyRepository
import com.android.openpressing.viewmodels.agency.state.AgencyState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class AgencyViewModel @Inject constructor
    (
    private val agencyRepository : AgencyRepository
): ViewModel(){

    private  val _availableAgencies = MutableStateFlow<AgencyState>(AgencyState.Empty)
    var availableagencies: StateFlow<AgencyState> = _availableAgencies

    fun getAll() {
        _availableAgencies .value = AgencyState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val agency = agencyRepository.getAll()
                _availableAgencies.value= AgencyState .Success.AgenciesSuccess(agency)

            } catch (exception: HttpException) {
                _availableAgencies.value= AgencyState.Error("No internet connection")

            }
            catch (exception: WindowManager.InvalidDisplayException) {
                _availableAgencies.value= AgencyState.Error("something went wong")

            }
        }

    }

    fun findBById(id: Int): Flow <Agency> = flow {
        emit(agencyRepository.getById(id))
    }.flowOn(Dispatchers.IO)


    fun getById(id: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val agency = agencyRepository.getById( id)
            }
        } catch (e: Exception) {

        }
    }

    fun save(agency: Agency) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
                agencyRepository .save(agency)
            }

        } catch (e: Exception) {

        }
    }

    fun update(id: Int,agency: Agency) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
                val updatedAgency = agencyRepository.update(id, agency)
                if (updatedAgency.equals(agency)) {

                }
            }

        }
        catch (e: Exception) {
        }
    }
}
