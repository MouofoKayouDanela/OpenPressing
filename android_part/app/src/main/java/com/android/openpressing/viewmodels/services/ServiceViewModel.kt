package com.android.openpressing.viewmodels.services

import android.view.WindowManager.InvalidDisplayException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.repositories.services.ServiceRepository
import com.android.openpressing.data.models.service.Service
import com.android.openpressing.viewmodels.services.state.RequirementState
import com.android.openpressing.viewmodels.services.state.ServicesStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class ServiceViewModel @Inject constructor(

    private val serviceRepository: ServiceRepository)
    :ViewModel()
     {

private  val _availableservices = MutableStateFlow<ServicesStates>(ServicesStates.Empty)
private var availableservice: StateFlow<ServicesStates> = _availableservices

init {
    getAll()

}

        fun getAll() {
            _availableservices.value = ServicesStates.Loading

            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val services = serviceRepository.getAll()
                    _availableservices.value= ServicesStates.Success(services)

                } catch (exception: HttpException ) {
                    _availableservices.value= ServicesStates.Error("No internet connection")

                }
                catch (exception: InvalidDisplayException ) {
                _availableservices.value= ServicesStates.Error("something went wong")

            }
            }

        }

        fun getById(id: Int) {
            try {
                viewModelScope.launch(Dispatchers.IO) {
                    val service = serviceRepository.getById(id)
                }
            } catch (e: Exception) {

            }
        }

        fun save(service: Service) {
            try {

                viewModelScope.launch(Dispatchers.IO) {
                    serviceRepository.save(service)
                }

            } catch (e: Exception) {

            }
        }

        fun update(id: Int, service: Service) {
            try {

                viewModelScope.launch(Dispatchers.IO) {
                    val updatedService = serviceRepository.update(id, service)
                    if (updatedService.equals(service)){

                    }
                }

            } catch (e: Exception) {

            }
        }
}