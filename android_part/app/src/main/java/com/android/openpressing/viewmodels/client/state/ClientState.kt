package com.android.openpressing.viewmodels.client.state

import com.android.openpressing.data.models.client.Client

sealed class ClientState {

    object Empty : ClientState()

    object Loading : ClientState()

    sealed class Success : ClientState() {

        data class ClientSuccess(val data: Client) : Success()
    }

    data class Error(val message: String) : ClientState()

}
