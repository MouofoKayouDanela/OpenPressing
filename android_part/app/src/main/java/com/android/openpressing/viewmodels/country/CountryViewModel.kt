package com.android.openpressing.viewmodels.country

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.city.City
import com.android.openpressing.data.models.city.CityData
import com.android.openpressing.data.models.country.Countries
import com.android.openpressing.data.models.country.Country
import com.android.openpressing.data.models.country.CountryData
import com.android.openpressing.repositories.country.CountryRepository
import com.android.openpressing.repositories.laundry.city.CityRepository
import com.android.openpressing.viewmodels.city.state.CityState
import com.android.openpressing.viewmodels.country.state.CountryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject


@HiltViewModel
class CountryViewModel @Inject constructor(
    private val countryRepository : CountryRepository

): ViewModel(){

    private  val _availableCountries = MutableStateFlow<CountryState>(CountryState.Empty)
    var availableCountries: StateFlow<CountryState> = _availableCountries

    fun getAll() {
        _availableCountries .value = CountryState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val countries = countryRepository.getAll()
                _availableCountries.value= CountryState .Success.CountriesSuccess(countries)

            } catch (exception: HttpException) {
                _availableCountries.value= CountryState.Error("No internet connection")

            }
            catch (exception: WindowManager.InvalidDisplayException) {
                _availableCountries.value= CountryState.Error("something went wong")

            }
        }

    }

    fun findById(id: Int): Flow<Country> = flow {
        emit(countryRepository.getById(id))
    }.flowOn(Dispatchers.IO)

    fun findAll(): Flow<MutableList<CountryData>> = flow {
        emit(countryRepository.getAll())
    }.flowOn(Dispatchers.IO)


    fun getById(id: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val city = countryRepository.getById( id)
            }
        } catch (e: Exception) {

        }
    }

    fun save(country: Country) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
                countryRepository.save(country)
            }

        } catch (e: Exception) {

        }
    }

    fun update(id: Int,country: Country) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
                val updatedAgency = countryRepository.update(id, country)
                if (updatedAgency.equals(country)) {

                }
            }

        }
        catch (e: Exception) {
        }
    }
}

}