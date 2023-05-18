package com.android.openpressing.viewmodels.user

import android.media.CamcorderProfile.getAll
import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.service.Service
import com.android.openpressing.repositories.services.ServiceRepository
import com.android.openpressing.viewmodels.services.state.ServicesStates
import com.android.openpressing.viewmodels.services.state.UserStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

//@HiltViewModel
/*class UserViewModel @Inject constructor(
    private val userViewModel: UserViewModel
) :ViewModel(){

    private  val _availableusers = MutableStateFlow<UserStates>(UserStates.Empty)
    private var availableuser: StateFlow<UserStates> = _availableusers

    init {
        getAll()

    }

    fun getAll() {
        _availableusers.value = UserStates.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val users = userRepository.getAll()
                _availableusers.value= UserStates.Success(users)

            } catch (exception: HttpException) {
                _availableusers.value= UserStates.Error("No internet connection")

            }
            catch (exception: WindowManager.InvalidDisplayException) {
                _availableusers.value= UserStates.Error("something went wrong")

            }
        }

    }

    fun getById(id: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val service = userRepository.getById(id)
            }
        } catch (e: Exception) {

        }
    }

    fun save(service: Service) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
               userRepository.save(service)
            }

        } catch (e: Exception) {

        }
    }

    fun update(id: Int, service: Service) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
                val updatedService = userRepository.update(id, service)
                if (updatedService.equals(service)){

                }
            }

        } catch (e: Exception) {

        }
    }
}*/