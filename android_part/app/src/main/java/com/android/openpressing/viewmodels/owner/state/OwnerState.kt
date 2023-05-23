package com.android.openpressing.viewmodels.owner.state


import com.android.openpressing.data.models.owner.Owner
import com.android.openpressing.data.models.owner.OwnerData


sealed class OwnerState {

    object Empty: OwnerState()

    object Loading: OwnerState()

    sealed class Success : OwnerState() {

        data class OwnerSuccess(val data: Owner) : Success()

        data class OwnersSuccess(val data: MutableList<OwnerData>) : Success()
    }

    data class Error(val message: String) : OwnerState()
}
