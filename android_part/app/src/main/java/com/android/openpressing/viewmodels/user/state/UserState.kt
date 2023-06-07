package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.user.User

sealed class UserState{

    object Empty: UserState()
    object  Loading: UserState()
    sealed class Success : UserState() {
        data class  UsersSuccess(val data: MutableList<User>): Success()
        data class UserSuccess(val data: User) : Success()
    }
    class Error(val message: String):UserState()
}


