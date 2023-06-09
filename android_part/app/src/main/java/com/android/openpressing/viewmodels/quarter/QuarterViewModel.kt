package com.android.openpressing.viewmodels.quarter

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.city.CityData
import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.quarter.QuarterData
import com.android.openpressing.repositories.quarter.QuarterRepository
import com.android.openpressing.viewmodels.quarter.state.QuarterState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

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

    fun findAll() : Flow<MutableList<QuarterData>> = flow {
        emit(quarterRepository.getAll())
    }.flowOn(Dispatchers.IO)

    fun getById(id: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val quarter = quarterRepository.getById( id)
            }
        } catch (e: Exception) {

        }
    }

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
