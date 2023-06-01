package com.android.openpressing.viewmodels.country.state

import com.android.openpressing.data.models.city.City
import com.android.openpressing.data.models.city.CityData
import com.android.openpressing.data.models.country.Country
import com.android.openpressing.data.models.country.CountryData
import com.android.openpressing.viewmodels.city.state.CityState

sealed class CountryState {
    object Empty : CountryState()

    object Loading : CountryState()

    sealed class Success : CountryState() {

        data class CountrySuccess(val data: Country) : Success()

        data class CountriesSuccess(val data: MutableList<CountryData>) : Success()
    }

    data class Error(val message: String) : CountryState()
}