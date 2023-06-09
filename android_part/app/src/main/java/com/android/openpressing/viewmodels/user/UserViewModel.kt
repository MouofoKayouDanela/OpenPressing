package com.android.openpressing.viewmodels.user

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.client.ClientData
import com.android.openpressing.data.models.user.User
import com.android.openpressing.data.models.user.UserData
import com.android.openpressing.repositories.user.UserRepository
import com.android.openpressing.viewmodels.services.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import okio.IOException
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
    
    fun updateUser(id: Int, user: User): Flow<User> = flow {
        emit(userRepository.update(id, user))
    }.flowOn(Dispatchers.IO)

    fun getAll() {
        _userState.value = UserState.Loading

        viewModelScope.launch {
            try {
                val users = userRepository.getAll()
                _userState.value = UserState.Success.UsersSuccess(users.toMutableList())
            } catch (e: IOException) {
                _userState.value = UserState.Error("No internet connection !")
            } catch (e: HttpException) {
                _userState.value = UserState.Error("Something went wrong !")
            }
        }
    }
    fun fineAll():Flow<List<User>> = flow {
        emit(userRepository.getAll())
    }. flowOn(Dispatchers.IO)



}