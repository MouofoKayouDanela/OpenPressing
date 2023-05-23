package com.android.openpressing.viewmodels.owner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.owner.Owner
import com.android.openpressing.repositories.owner.OwnerRepository
import com.android.openpressing.viewmodels.client.state.ClientState
import com.android.openpressing.viewmodels.owner.state.OwnerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class OwnerViewModel @Inject constructor(
    private  val ownerRepository: OwnerRepository
): ViewModel() {

    private val _ownerState = MutableStateFlow<OwnerState>(OwnerState.Empty)
    val ownerState = _ownerState.asStateFlow()

    fun getById(id: Int) : Flow<Owner> = flow {
        emit(ownerRepository.getById(id))
    }.flowOn(Dispatchers.IO)

    fun getAll() {
        _ownerState.value = OwnerState.Loading
package com.android.openpressing.viewmodels.owner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.owner.Owner
import com.android.openpressing.repositories.owner.OwnerRepository
import com.android.openpressing.viewmodels.client.state.ClientState
import com.android.openpressing.viewmodels.owner.state.OwnerState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class OwnerViewModel @Inject constructor(
    private  val ownerRepository: OwnerRepository
): ViewModel() {

    private val _ownerState = MutableStateFlow<OwnerState>(OwnerState.Empty)
    val ownerState = _ownerState.asStateFlow()

    fun getById(id: Int) : Flow<Owner> = flow {
        emit(ownerRepository.getById(id))
    }.flowOn(Dispatchers.IO)

    fun getAll() {
        _ownerState.value = OwnerState.Loading

        viewModelScope.launch {
            try {
                val owners = ownerRepository.getAll()
                _ownerState.value = OwnerState.Success.OwnersSuccess(owners)
            } catch (e: IOException) {
                _ownerState.value = OwnerState.Error("No internet connection !")
            } catch (e: HttpException) {
                _ownerState.value = OwnerState.Error("Something went wrong !")
            }
        }
    }
}