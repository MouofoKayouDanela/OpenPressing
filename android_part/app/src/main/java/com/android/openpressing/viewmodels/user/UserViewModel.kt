package com.android.openpressing.viewmodels.user

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.repositories.user.UserRepository
import com.android.openpressing.viewmodels.services.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _userState = MutableStateFlow<UserState>(UserState.Empty)
    val userState = _userState.asStateFlow()

    fun getById(id: Int) {
        _userState.value = UserState.Loading

        try {
            viewModelScope.launch(Dispatchers.IO) {

                val user = userRepository.getById(id)
                _userState.value = UserState.Success.UserSuccess(user)
            }
        } catch (exception: HttpException) {
            _userState.value= UserState.Error("No internet connection")

        }
        catch (exception: WindowManager.InvalidDisplayException) {
            _userState.value= UserState.Error("something went wrong")

        }
    }

}