package com.android.openpressing.viewmodels.Annonce.state

import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.agency.AgencyData
import com.android.openpressing.data.models.annonce.Announce
import com.android.openpressing.data.models.annonce.AnnounceData
import com.android.openpressing.viewmodels.agency.state.AgencyState

sealed class AnnonceState{

    object Empty: AnnonceState()

    object  Loading: AnnonceState()

    sealed class Success : AnnonceState(){
        class  AnnoncesSuccess(val data: MutableList<AnnounceData>): Success()
        class AnnonceSuccess(val data : Announce) : Success()
    }

    class Error(val message: String): AnnonceState()
}
