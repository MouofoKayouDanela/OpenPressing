package com.android.openpressing.repositories.message

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.message.Message
import com.android.openpressing.data.models.message.MessageData
import javax.inject.Inject

class MessageRepository @Inject constructor(
    private val messageApi : OpenPressingStrapiApi.MessageApi
) {
    suspend fun getAll() : MutableList<MessageData> = messageApi.getAll().data

    suspend fun getById(id: Int) : Message = messageApi.getById(id)

    suspend fun save(message : Message) = messageApi.save(message)

    suspend fun update(id: Int,message : Message ) : Message = messageApi.update(id, message)

    suspend fun delete(id: Int) {

        val deletingMessage = getById(id)
        deletingMessage.data.attributes.confirmed = false

        update(id, deletingMessage)
    }
}