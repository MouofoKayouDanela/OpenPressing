package com.android.openpressing.viewmodels.pressing

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.data.models.pressing.Pressing
import com.android.openpressing.data.models.pressing.PressingData
import com.android.openpressing.data.models.user.User
import com.android.openpressing.repositories.pressing.PressingRepository
import com.android.openpressing.viewmodels.services.state.LaundryState
import com.android.openpressing.viewmodels.services.state.PressingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class PressingViewModel @Inject constructor(
    private val pressingRepository : PressingRepository
):ViewModel()
{
    private val _availablePressing = MutableStateFlow<PressingState>(PressingState.Empty)

    var availablePressing  = _availablePressing.asStateFlow()

    fun getAll(){
        _availablePressing.value = PressingState.Loading

        viewModelScope.launch (Dispatchers.IO ) {
            try {
                val pressing = pressingRepository.getAll()
                _availablePressing.value=PressingState.Success.PressingsSuccess(pressing)
            }
            catch (exception: HttpException){
                _availablePressing.value=PressingState.Error("No internet connection")
            }
            catch (exception: WindowManager.InvalidDisplayException){
                _availablePressing.value=PressingState.Error("something went wong")
            }
        }
    }

    fun findAll() : Flow<List<PressingData>> = flow {
        emit(pressingRepository.getAll())
    }.flowOn(Dispatchers.IO)

    fun getByIds(id: Int){
        try {
            viewModelScope.launch (Dispatchers.IO){
                val pressing = pressingRepository.getById(id)
            }
        }
        catch (e: Exception){

        }
    }
    fun getById(id: Int) : Flow<Pressing> = flow {
        emit( pressingRepository.getById(id))
    }.flowOn(Dispatchers.IO)

    fun save(pressing : Pressing){
        try {
            viewModelScope.launch(Dispatchers.IO){
                pressingRepository.save(pressing)
            }
        }
        catch (e: Exception){

        }
    }

    fun update(id: Int,pressing: Pressing){
        try {
            viewModelScope.launch(Dispatchers.IO){
                val updatedPressing = pressingRepository.update(id, pressing)

                if(updatedPressing.equals(pressing)){

                }
            }
        }
        catch (e: Exception){

        }
    }
}