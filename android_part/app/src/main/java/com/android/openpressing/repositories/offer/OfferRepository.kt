package com.android.openpressing.repositories.offer

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.offer.Offer
import com.android.openpressing.data.models.offer.OfferData
import javax.inject.Inject

class OfferRepository @Inject constructor(
    private val offerApi : OpenPressingStrapiApi.OfferApi
) {
    suspend fun getAll() : MutableList<OfferData> = offerApi.getAll().data

    suspend fun getById(id: Int) : Offer = offerApi.getById(id)

    suspend fun save(offer : Offer ) = offerApi.save(offer)

    suspend fun update(id: Int,offer : Offer) : Offer = offerApi.update(id, offer)

    suspend fun delete(id: Int) {

        val deletingOffer = getById(id)
        deletingOffer.data.attributes.confirmed = false

        update(id, deletingOffer)
    }
}