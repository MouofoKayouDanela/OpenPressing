package com.android.openpressing.viewmodels.requirement_detail

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.requirement_detail.RequirementDetail
import com.android.openpressing.repositories.requirement_detail.RequirementDetailRepository
import com.android.openpressing.viewmodels.requirement_detail.state.RequirementDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
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

}