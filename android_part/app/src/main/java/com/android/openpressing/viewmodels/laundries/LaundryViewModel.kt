package com.android.openpressing.viewmodels.laundries

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.repositories.laundry.LaundryRepository
import com.android.openpressing.viewmodels.services.state.LaundryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class LaundryViewModel @Inject constructor
    (
    private val laundryRepository: LaundryRepository):ViewModel(){



    private  val _availablelaundries = MutableStateFlow<LaundryState>(LaundryState.Empty)
    private var availablelaundries: StateFlow<LaundryState> = _availablelaundries

    init {
        getAll()

    }

    fun getAll() {
        _availablelaundries .value = LaundryState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val laundries = laundryRepository.getAll()
                _availablelaundries.value=LaundryState .Success(laundries)

            } catch (exception: HttpException) {
                _availablelaundries.value= LaundryState.Error("No internet connection")

            }
            catch (exception: WindowManager.InvalidDisplayException) {
                _availablelaundries.value= LaundryState.Error("something went wong")

            }
        }

    }

    fun getById(id: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val laundry = laundryRepository.getById( id)
            }
        } catch (e: Exception) {

        }
    }

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

        }
        catch (e: Exception) {
        }
    }
    }
