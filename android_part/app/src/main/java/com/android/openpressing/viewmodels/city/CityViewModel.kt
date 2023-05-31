package com.android.openpressing.viewmodels.city

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.city.City
import com.android.openpressing.data.models.city.CityData
import com.android.openpressing.repositories.laundry.city.CityRepository
import com.android.openpressing.viewmodels.city.state.CityState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor
    (
    private val cityRepository : CityRepository
): ViewModel(){

    private  val _availableCities = MutableStateFlow<CityState>(CityState.Empty)
    var availableCities: StateFlow<CityState> = _availableCities

    fun getAll() {
        _availableCities .value = CityState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val cities = cityRepository.getAll()
                _availableCities.value= CityState .Success.CitiesSuccess(cities)

            } catch (exception: HttpException) {
                _availableCities.value= CityState.Error("No internet connection")

            }
            catch (exception: WindowManager.InvalidDisplayException) {
                _availableCities.value= CityState.Error("something went wong")

            }
        }

    }

    fun findById(id: Int): Flow<City> = flow {
        emit(cityRepository.getById(id))
    }.flowOn(Dispatchers.IO)

    fun findAll(): Flow<MutableList<CityData>> = flow {
        emit(cityRepository.getAll())
    }.flowOn(Dispatchers.IO)


    fun getById(id: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val city = cityRepository.getById( id)
            }
        } catch (e: Exception) {

        }
    }

    fun save(city : City) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
               cityRepository .save(city)
            }

        } catch (e: Exception) {

        }
    }

    fun update(id: Int,city : City) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
                val updatedAgency = cityRepository.update(id, city)
                if (updatedAgency.equals(city)) {

                }
            }

        }
        catch (e: Exception) {
        }
    }
}