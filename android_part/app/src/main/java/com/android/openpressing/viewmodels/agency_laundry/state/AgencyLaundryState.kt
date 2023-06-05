package com.android.openpressing.viewmodels.agency_laundry.state

sealed class AgencyLaundryState {

    object Empty : AgencyLaundryState()

    object Loading : AgencyLaundryState()

    sealed class Success : AgencyLaundryState() {

        data class Save(val result: Boolean) : Success()

        data class Delete(val result: Boolean) : Success()
    }

}
