package com.android.openpressing.viewmodels.client

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.client.Client
import com.android.openpressing.data.models.client.ClientData
import com.android.openpressing.repositories.client.ClientRepository
import com.android.openpressing.viewmodels.client.state.ClientState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class ClientViewModel @Inject constructor(
    private val clientRepository: ClientRepository
) : ViewModel() {

    private val _clientState = MutableStateFlow<ClientState>(ClientState.Empty)
    val clientState = _clientState.asStateFlow()

    fun getById(id: Int) : Flow<Client> = flow {
        emit(clientRepository.getById(id))
    }.flowOn(Dispatchers.IO)

    fun findAll() : Flow<MutableList<ClientData> > = flow {
        emit(clientRepository.getAll())
    }.flowOn(Dispatchers.IO)

    fun getAll() {
        _clientState.value = ClientState.Loading

        viewModelScope.launch {
            try {
                val clients = clientRepository.getAll()
                _clientState.value = ClientState.Success.ClientsSuccess(clients)
           } catch (e: IOException) {
                _clientState.value = ClientState.Error("No internet connection !")
           } catch (e: HttpException) {
                _clientState.value = ClientState.Error("Something went wrong !")
           }
       }
    }

}