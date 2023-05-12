package com.android.openpressing.viewmodels.agency

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.repositories.laundry.LaundryRepository
import com.android.openpressing.viewmodels.services.state.LaundryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject


@HiltViewModel
class AgencyViewModel @Inject constructor
    ( private val agency:Agency): ViewModel() {


}