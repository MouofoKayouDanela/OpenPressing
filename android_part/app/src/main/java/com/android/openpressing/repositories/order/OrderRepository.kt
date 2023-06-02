package com.android.openpressing.repositories.order

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.offer.Offer
import com.android.openpressing.data.models.order.Order
import com.android.openpressing.data.models.order.OrderData
import javax.inject.Inject

class OrderRepository @Inject constructor(
    private val orderApi : OpenPressingStrapiApi.OrderApi
) {
    suspend fun getAll() : MutableList<OrderData> = orderApi.getAll().data

    suspend fun getById(id: Int) : Order = orderApi.getById(id)

    suspend fun save(order : Order) = orderApi.save(order)

    suspend fun update(id: Int,order : Order) : Order = orderApi.update(id , order)

    suspend fun delete(id: Int) {

        val deletingOrder = getById(id)
        deletingOrder.data.attributes.confirmed = false

        update(id, deletingOrder)
    }
}