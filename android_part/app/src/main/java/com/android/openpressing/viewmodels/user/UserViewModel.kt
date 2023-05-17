package com.android.openpressing.viewmodels.user

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.user.User
import com.android.openpressing.repositories.user.UserRepository
import com.android.openpressing.viewmodels.services.state.UserStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val userRepository : UserRepository
): ViewModel()
{
    private val _availableUser = MutableStateFlow<UserStates>(UserStates.Empty)

    private var availableUser : StateFlow<UserStates> = _availableUser

    fun getAll(){
        _availableUser.value = UserStates.Loading

        viewModelScope.launch (Dispatchers.IO ) {
            try {
                val user = userRepository.getAll()
                _availableUser.value= UserStates.Success(user)
            }
            catch (exception: HttpException){
                _availableUser.value= UserStates.Error("No internet connection")
            }
            catch (exception: WindowManager.InvalidDisplayException){
                _availableUser.value= UserStates.Error("something went wong")
            }
        }
    }

    fun getById(id: Int){
        try {
            viewModelScope.launch (Dispatchers.IO){
                val user = userRepository.getById(id)
            }
        }
        catch (e: Exception){

        }
    }

    fun save(user : User){
        try {
            viewModelScope.launch(Dispatchers.IO){
                userRepository.save(user)
            }
        }
        catch (e: Exception){

        }
    }

    fun update(id: Int,user : User){
        try {
            viewModelScope.launch(Dispatchers.IO){
                val updatedPressing = userRepository.update(id, user)

                if(updatedPressing.equals(user)){

                }
            }
        }
        catch (e: Exception){

        }
    }
}