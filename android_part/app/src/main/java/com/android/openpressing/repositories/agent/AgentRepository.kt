package com.android.openpressing.repositories.agent

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.agent.Agent
import com.android.openpressing.data.models.agent.AgentData
import javax.inject.Inject

class AgentRepository @Inject constructor(
    private val agentApi : OpenPressingStrapiApi.AgentApi
){
    suspend fun getAll() : MutableList<AgentData> = agentApi.getAll().data

    suspend fun getById(id:Int) : Agent = agentApi.getById(id)

    suspend fun save(agent : Agent ) = agentApi.save(agent)

    suspend fun update(id : Int,agent : Agent) : Agent = agentApi.update(id, agent)

    suspend fun delete(id : Int){
        val deletingAgent = getById(id)
        deletingAgent.data.agentAttributes

        update(id, deletingAgent )
    }


}