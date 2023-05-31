package com.android.openpressing.viewmodels.message

import androidx.lifecycle.ViewModel
import com.android.openpressing.data.models.message.MessageData
import com.android.openpressing.repositories.message.MessageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
    private val repository: MessageRepository
) : ViewModel() {

    fun findAll() : Flow<MutableList<MessageData>> = flow {
        emit(repository.getAll())
    }.flowOn(Dispatchers.IO)
}