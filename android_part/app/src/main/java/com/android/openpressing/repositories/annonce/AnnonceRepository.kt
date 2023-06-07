package com.android.openpressing.repositories.annonce

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.annonce.Announce
import com.android.openpressing.data.models.annonce.AnnounceData
import javax.inject.Inject

class AnnonceRepository @Inject constructor(
   private val annonceApi : OpenPressingStrapiApi.AnnonceApi
){
    suspend fun getAll() : MutableList<AnnounceData> = annonceApi.getAll().data

    suspend fun getById(id:Int) : Announce = annonceApi.getById(id)

    suspend fun save(announce: Announce) =annonceApi.save(announce)

    suspend fun update(id : Int,announce: Announce) : Announce = annonceApi.update(id , announce)

    suspend fun delete(id : Int){
        val deletingAnnounce = getById(id)
        deletingAnnounce.data.attributes.confirmed=false

        update(id, deletingAnnounce)
    }
}