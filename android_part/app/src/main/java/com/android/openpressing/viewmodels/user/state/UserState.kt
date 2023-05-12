package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.user.UserData

sealed class UserStates{

    object Empty: UserStates()
    object  Loading: UserStates()
    class  Success(val data: MutableList<UserData>): UserStates()
    class Error(val message: String):UserStates()
}


