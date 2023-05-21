package com.android.openpressing.viewmodels.requirement_detail

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.requirement_detail.RequirementDetail
import com.android.openpressing.data.models.requirement_detail.RequirementDetailData
import com.android.openpressing.repositories.requirement_detail.RequirementDetailRepository
import com.android.openpressing.viewmodels.requirement_detail.state.RequirementDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class RequirementDetailViewModel @Inject constructor(
    private val requirementDetailRepository: RequirementDetailRepository
) : ViewModel() {

    private val _requirementDetailState = MutableStateFlow<RequirementDetailState>(RequirementDetailState.Empty)
    val requirementDetailState = _requirementDetailState.asStateFlow()

    fun getById(id: Int) : Flow<RequirementDetail> = flow {
        emit(requirementDetailRepository.getById(id))
    }.flowOn(Dispatchers.IO)

    fun getAll() : Flow<List<RequirementDetailData>> = flow {
        emit(requirementDetailRepository.getAll())
    }.flowOn(Dispatchers.IO)

//    fun getAll() {
//        _requirementDetailState.value = RequirementDetailState.Loading
//
//        viewModelScope.launch {
//            try {
//                val requirementDetails = requirementDetailRepository.getAll()
//                _requirementDetailState.value = RequirementDetailState.Success.RdsSuccess(requirementDetails)
//            } catch (e: IOException) {
//                _requirementDetailState.value = RequirementDetailState.Error("No internet connection !")
//            } catch (e: HttpException) {
//                _requirementDetailState.value = RequirementDetailState.Error("Something went wrong !")
//            }
//        }
//    }

}