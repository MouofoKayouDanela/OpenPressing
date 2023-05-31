package com.android.openpressing.viewmodels.Annonce

import android.view.WindowManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.agency.AgencyData
import com.android.openpressing.data.models.annonce.Announce
import com.android.openpressing.data.models.annonce.AnnounceData
import com.android.openpressing.repositories.annonce.AnnonceRepository
import com.android.openpressing.viewmodels.Annonce.state.AnnonceState
import com.android.openpressing.viewmodels.agency.state.AgencyState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject


@HiltViewModel
class AnnonceViewModel @Inject constructor(
    private val annonceRepository: AnnonceRepository
): ViewModel() {

    private  val _availableAnnounces = MutableStateFlow<AnnonceState>(AnnonceState.Empty)
    var availableAnnounces: StateFlow<AnnonceState> = _availableAnnounces

    fun findById(id: Int): Flow<Announce> = flow {
        emit(annonceRepository.getById(id))
    }.flowOn(Dispatchers.IO)

    fun getById(id: Int) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val announce = annonceRepository.getById( id)
            }
        } catch (e: Exception) {

        }
    }


    fun findAll(): Flow <MutableList<AnnounceData> > = flow {
        emit(annonceRepository.getAll())
    }.flowOn(Dispatchers.IO)

    fun getAll() {
        _availableAnnounces .value = AnnonceState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val annonce = annonceRepository.getAll()
                _availableAnnounces.value= AnnonceState .Success.AnnoncesSuccess(annonce)

            } catch (exception: HttpException) {
                _availableAnnounces.value= AnnonceState.Error("No internet connection")

            }
            catch (exception: WindowManager.InvalidDisplayException) {
                _availableAnnounces.value= AnnonceState.Error("something went wong")

            }
        }

    }


    fun save(announce: Announce) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
                annonceRepository .save(announce)
            }

        } catch (e: Exception) {

        }
    }

    fun update(id: Int,announce: Announce) {
        try {

            viewModelScope.launch(Dispatchers.IO) {
                val updatedAnnounce = annonceRepository.update(id, announce)
                if (updatedAnnounce.equals(announce)) {

                }
            }
        }
        catch (e: Exception) {
        }
    }
}