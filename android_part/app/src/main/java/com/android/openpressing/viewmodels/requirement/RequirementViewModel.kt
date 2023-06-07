package com.android.openpressing.viewmodels.requirement

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.requirement.Requirement
import com.android.openpressing.data.models.requirement.RequirementData
import com.android.openpressing.data.models.requirement.RequirementInfo
import com.android.openpressing.repositories.requirement.RequirementRepository
import com.android.openpressing.viewmodels.services.state.RequirementState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject
    @HiltViewModel
    class RequirementViewModel @Inject constructor(
        private val requirementRepository: RequirementRepository
    )
        : ViewModel()
    {

        private  val _requirementState = MutableStateFlow<RequirementState>(RequirementState.Empty)
        var requirementState: StateFlow<RequirementState> = _requirementState

        fun getAll() {
            _requirementState.value = RequirementState.Loading

            viewModelScope.launch {
                try {
                    val requirements = requirementRepository.getAll()
                    _requirementState.value= RequirementState.Success.RequirementsSuccess(requirements)

                } catch (exception: HttpException) {
                    _requirementState.value= RequirementState.Error("No internet connection")

                }
                catch (exception: WindowManager.InvalidDisplayException) {
                    _requirementState.value= RequirementState.Error("something went wong")

                }
            }

        }

        fun findAll() : Flow<MutableList<RequirementData>> = flow{
            emit(requirementRepository.getAll())
        }.flowOn(Dispatchers.IO)

        fun findById(id: Int) {
            _requirementState.value = RequirementState.Loading
            viewModelScope.launch {
                try {
                    val requirement = requirementRepository.getById(id)
                    _requirementState.value = RequirementState.Success.RequirementSuccess(requirement)
                } catch (exception: HttpException) {
                    _requirementState.value= RequirementState.Error("No internet connection")

                }
                catch (exception: WindowManager.InvalidDisplayException) {
                    _requirementState.value= RequirementState.Error("something went wong")

                }
            }
        }

        fun getById(id: Int) : Flow<Requirement> = flow {
            emit(requirementRepository.getById(id))
        }.flowOn(Dispatchers.IO)

        fun save(requirement: RequirementInfo) {
            try {
                _requirementState.value = RequirementState.Loading
                viewModelScope.launch(Dispatchers.IO) {
                    val response = requirementRepository .save(requirement)
                    _requirementState.value = RequirementState.Success.Save(response.isSuccessful)
                }

            } catch (e: Exception) {

            }
        }

        fun update(id: Int, requirement: RequirementInfo) {
            try {

                viewModelScope.launch(Dispatchers.IO) {
                    val updatedService = requirementRepository.update(id, requirement)
                    if (updatedService.equals(requirement)){

                    }
                }

            } catch (e: Exception) {

            }
        }

        fun delete(id: Int) = flow {
            emit(requirementRepository.delete(id))
        }.flowOn(Dispatchers.IO)
    }