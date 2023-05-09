package com.android.openpressing.viewmodels.services

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.repositories.services.ServiceRepository
import com.android.openpressing.data.models.service.Service
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ServiceViewModel @Inject constructor(
    private val serviceRepository: ServiceRepository
    ) : ViewModel()
{

        fun getAll() {

            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val services = serviceRepository.getAll()
                } catch (e: Exception) {

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