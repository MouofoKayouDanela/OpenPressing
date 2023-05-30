package com.android.openpressing.viewmodels.city.state

import com.android.openpressing.data.models.city.City
import com.android.openpressing.data.models.city.CityData


sealed class CityState {

     object Empty : CityState()

     object Loading : CityState()

     sealed class Success : CityState() {

         data class CitySuccess(val data: City) : Success()

         data class CitiesSuccess(val data: MutableList<CityData>) : Success()
     }

     data class Error(val message: String) : CityState()
}