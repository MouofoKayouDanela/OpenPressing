package com.android.openpressing.viewmodels.requirement

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.requirement.Requirement
import com.android.openpressing.data.models.service.Service
import com.android.openpressing.repositories.requirement.RequirementRepository
import com.android.openpressing.repositories.services.ServiceRepository
import com.android.openpressing.viewmodels.services.state.RequirementState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class RequirementViewModel {
    @HiltViewModel
    class ServiceViewModel @Inject constructor(
        private val requirementRepository: RequirementRepository
    )
        : ViewModel()
    {

        private  val _availablerequirement = MutableStateFlow<RequirementState>(RequirementState.Empty)
        var avilablerequirement: StateFlow<RequirementState> = _availablerequirement

        init {
            getAll()

        }

        fun getAll() {
            _availablerequirement.value = RequirementState.Loading

            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val requirements = requirementRepository.getAll()
                    _availablerequirement.value= RequirementState.Success(requirements)

                } catch (exception: HttpException) {
                    _availablerequirement.value= RequirementState.Error("No internet connection")

                }
                catch (exception: WindowManager.InvalidDisplayException) {
                    _availablerequirement.value= RequirementState.Error("something went wong")

                }
            }

        }

        fun getById(id: Int) {
            try {
                viewModelScope.launch(Dispatchers.IO) {
                    val requirement = requirementRepository.getById(id)
                }
            } catch (e: Exception) {

            }
        }

        fun save(requirement:Requirement ) {
            try {

                viewModelScope.launch(Dispatchers.IO) {
                    requirementRepository .save(requirement)
                }

            } catch (e: Exception) {

            }
        }

        fun update(id: Int, requirement: Requirement) {
            try {

                viewModelScope.launch(Dispatchers.IO) {
                    val updatedService = requirementRepository.update(id, requirement)
                    if (updatedService.equals(requirement)){

                    }
                }

            } catch (e: Exception) {

            }
        }
    }
}