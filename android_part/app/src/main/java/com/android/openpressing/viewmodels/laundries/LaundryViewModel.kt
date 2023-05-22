package com.android.openpressing.viewmodels.laundries

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.repositories.laundry.LaundryRepository
import com.android.openpressing.viewmodels.services.state.LaundryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class LaundryViewModel @Inject constructor
    ( private val laundryRepository: LaundryRepository):ViewModel(){



    private  val _laundryState = MutableStateFlow<LaundryState>(LaundryState.Empty)
    val laundryState: StateFlow<LaundryState> = _laundryState


    fun getAll() {
        _laundryState .value = LaundryState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val laundries = laundryRepository.getAll()
                _laundryState.value=LaundryState.Success.LaundriesSuccess(laundries)

            } catch (exception: HttpException) {
                _laundryState.value= LaundryState.Error("No internet connection")

            }
            catch (exception: WindowManager.InvalidDisplayException) {
                _laundryState.value= LaundryState.Error("something went wong")

            }
        }

    }

    fun getById(id: Int) : Flow<Laundry> = flow {
        emit(laundryRepository.getById(id))
    }.flowOn(Dispatchers.IO)

    fun save(laundry: Laundry) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
                laundryRepository .save(laundry)
            }

        } catch (e: Exception) {

        }
    }

    fun update(id: Int,laundry: Laundry) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
                val updatedLaundry = laundryRepository.update(id, laundry)
                if (updatedLaundry.equals(laundry)) {

                }
            }

        } catch (e: Exception) {

        }
    }
    }
