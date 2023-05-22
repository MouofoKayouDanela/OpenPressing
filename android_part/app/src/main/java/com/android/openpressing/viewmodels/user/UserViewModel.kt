package com.android.openpressing.viewmodels.user

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.user.User
import com.android.openpressing.repositories.user.UserRepository
import com.android.openpressing.viewmodels.services.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _userState = MutableStateFlow<UserState>(UserState.Empty)
    val userState = _userState.asStateFlow()

    fun getById(id: Int) : Flow<User> = flow {
        emit(userRepository.getById(id))
    }.flowOn(Dispatchers.IO)

}