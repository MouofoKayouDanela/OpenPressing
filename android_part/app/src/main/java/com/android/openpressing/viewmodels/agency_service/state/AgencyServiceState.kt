package com.android.openpressing.viewmodels.agency_service.state

sealed class AgencyServiceState {

    object Empty : AgencyServiceState()

    object Loading : AgencyServiceState()

    sealed class Success : AgencyServiceState() {
        data class Save(val result: Boolean) : Success()
        data class Delete(val result: Boolean) : Success()
    }
}
