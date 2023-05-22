package com.android.openpressing.repositories.promotion

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.promotion.Promotion
import com.android.openpressing.data.models.promotion.PromotionData
import javax.inject.Inject

class PromotionRepository @Inject constructor(
    private val promotionApi : OpenPressingStrapiApi.PromotionApi
) {
    suspend fun getAll() : MutableList<PromotionData> = promotionApi.getAll().data

    suspend fun getById(id: Int) : Promotion = promotionApi.getById(id)

    suspend fun save(promotion : Promotion) = promotionApi.save(promotion)

    suspend fun update(id: Int,promotion : Promotion) : Promotion = promotionApi.update(id, promotion)

    suspend fun delete(id: Int) {

        val deletingPromotion = getById(id)
        deletingPromotion.data.attributes.confirmed = false

        update(id, deletingPromotion)
    }
}