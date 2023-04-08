package com.android.openpressing.client_module.viewmodels.services

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.client_module.repositories.services.ServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ServiceViewModel @Inject constructor(
    private val serviceRepository: ServiceRepository
    ) : ViewModel() {

        fun getAll() {

            viewModelScope.launch(Dispatchers.IO) {
                val services = serviceRepository.getAll()
            }

        }

        fun getById(id: Int) {
            viewModelScope.launch(Dispatchers.IO) {
                val service = serviceRepository.getById(id)
            }
        }
}