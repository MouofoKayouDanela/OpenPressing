package com.android.openpressing.viewmodels.quarter

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.agency.AgencyData
import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.quarter.QuarterData
import com.android.openpressing.data.models.requirement.Requirement
import com.android.openpressing.repositories.quarter.QuarterRepository
import com.android.openpressing.viewmodels.quarter.state.QuarterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject
@HiltViewModel
class QuarterViewModel  @Inject constructor
    (
    private val quarterRepository : QuarterRepository
    ): ViewModel()
{

    private  val _availableQuarter = MutableStateFlow<QuarterState>(QuarterState.Empty)

    var availableQuarter: StateFlow<QuarterState> = _availableQuarter

    fun getAll() {
        _availableQuarter.value = QuarterState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val quarter = quarterRepository.getAll()
                _availableQuarter.value= QuarterState.Success.QuartersSuccess(quarter)

            } catch (exception: HttpException) {
                _availableQuarter.value= QuarterState.Error("No internet connection")

            }
            catch (exception: WindowManager.InvalidDisplayException) {
                _availableQuarter.value= QuarterState.Error("something went wong")

            }
        }

    }

    fun findById(id: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val quarter = quarterRepository.getById( id)
            }
        } catch (e: Exception) {

        }
    }
    fun findAll(): Flow <MutableList<QuarterData> > = flow {
        emit(quarterRepository.getAll())
    }.flowOn(Dispatchers.IO)
    fun getById(id: Int) : Flow<Quarter > = flow {
        emit(quarterRepository .getById(id))
    }.flowOn(Dispatchers.IO)

    fun save(quarter : Quarter) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
                quarterRepository.save(quarter)
            }

        } catch (e: Exception) {

        }
    }

    fun update(id: Int,quarter : Quarter) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
                val updatedQuarter = quarterRepository.update(id, quarter)
                if (updatedQuarter.equals(quarter)) {

                }
            }

        }
        catch (e: Exception) {
        }
    }
}
