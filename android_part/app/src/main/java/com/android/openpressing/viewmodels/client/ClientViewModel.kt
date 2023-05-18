package com.android.openpressing.viewmodels.client

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.repositories.client.ClientRepository
import com.android.openpressing.viewmodels.client.state.ClientState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class ClientViewModel @Inject constructor(
    private val clientRepository: ClientRepository
) : ViewModel() {

    private val _clientState = MutableStateFlow<ClientState>(ClientState.Empty)
    val clientState = _clientState.asStateFlow()

    fun getById(id: Int) {

        try {
            _clientState.value = ClientState.Loading

            viewModelScope.launch(Dispatchers.IO) {
                val client = clientRepository.getById(id)
                _clientState.value = ClientState.Success.ClientSuccess(client)
            }
        } catch (exception: HttpException) {
            _clientState.value= ClientState.Error("No internet connection")

        }
        catch (exception: WindowManager.InvalidDisplayException) {
            _clientState.value= ClientState.Error("something went wong")

        }
    }

}