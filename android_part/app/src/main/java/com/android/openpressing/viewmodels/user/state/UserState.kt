package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.user.User
import com.android.openpressing.data.models.user.UserData

sealed class UserState{

    object Empty: UserState()
    object  Loading: UserState()
    sealed class Success : UserState() {
        data class  UsersSuccess(val data: MutableList<UserData>): Success()
        data class UserSuccess(val data: User) : Success()
    }
    class Error(val message: String):UserState()
}


