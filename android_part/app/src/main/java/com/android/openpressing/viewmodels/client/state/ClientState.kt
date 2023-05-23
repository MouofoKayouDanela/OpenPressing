package com.android.openpressing.viewmodels.client.state

import com.android.openpressing.data.models.client.Client
import com.android.openpressing.data.models.client.ClientData

sealed class ClientState {

    object Empty : ClientState()

    object Loading : ClientState()

    sealed class Success : ClientState() {

        data class ClientSuccess(val data: Client) : Success()

        data class ClientsSuccess(val data: MutableList<ClientData>) : Success()
    }

    data class Error(val message: String) : ClientState()

}
