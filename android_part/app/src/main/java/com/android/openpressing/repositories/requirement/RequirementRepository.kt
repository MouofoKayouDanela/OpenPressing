package com.android.openpressing.repositories.requirement

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.requirement.*
import retrofit2.Response
import javax.inject.Inject

class RequirementRepository @Inject constructor(
    private val requirementApi: OpenPressingStrapiApi.RequirementApi
) {

    suspend fun getAll() : MutableList<RequirementData> = requirementApi.getAll().data

    suspend fun getById(id: Int) : Requirement = requirementApi.getById(id)

    suspend fun save(requirement: RequirementInfo) = requirementApi.save(requirement)

    suspend fun update(id: Int, requirement: RequirementInfo) = requirementApi.update(id , requirement)

    suspend fun delete(id: Int) : Response<RequirementInfo> {

        val deletingRequirement = getById(id)

        return update(
                id,
                RequirementInfo(
                        RequirementInfoData(
                                id = deletingRequirement.data!!.id,
                                client = deletingRequirement.data!!.attributes.client.data.id!!,
                                requirement_details = deletingRequirement.data!!
                                    .attributes
                                    .requirement_details
                                    .data
                                    .map { it.id!! },
                                confirmed = false
                        )
                )
        )
    }

}