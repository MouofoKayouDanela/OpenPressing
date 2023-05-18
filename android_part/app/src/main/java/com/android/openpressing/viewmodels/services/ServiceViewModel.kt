package com.android.openpressing.viewmodels.services

import android.view.WindowManager.InvalidDisplayException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.repositories.services.ServiceRepository
import com.android.openpressing.data.models.service.Service
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

private  val _serviceState = MutableStateFlow<ServicesStates>(ServicesStates.Empty)
val serviceState: StateFlow<ServicesStates> = _serviceState

        fun getAll() {
            _serviceState.value = ServicesStates.Loading

            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val services = serviceRepository.getAll()
                    _serviceState.value= ServicesStates.Success.ServicesSuccess(services)

                } catch (exception: HttpException ) {
                    _serviceState.value= ServicesStates.Error("No internet connection")

                }
                catch (exception: InvalidDisplayException ) {
                _serviceState.value= ServicesStates.Error("something went wong")

                }
            }

        }

        fun getById(id: Int) {
            try {
                viewModelScope.launch(Dispatchers.IO) {
                    val service = serviceRepository.getById(id)
                    _serviceState.value = ServicesStates.Success.ServiceSuccess(service)
                }
            }  catch (exception: HttpException ) {
                _serviceState.value= ServicesStates.Error("No internet connection")

            }
            catch (exception: InvalidDisplayException ) {
                _serviceState.value= ServicesStates.Error("something went wong")

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