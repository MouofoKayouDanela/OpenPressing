package com.android.openpressing.repositories.requirement

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.requirement.Requirement
import com.android.openpressing.data.models.requirement.RequirementData
import com.android.openpressing.data.models.requirement.Requirements
import javax.inject.Inject

class RequirementRepository @Inject constructor(
    private val requirementApi: OpenPressingStrapiApi.RequirementApi
) {

    suspend fun getAll() : MutableList<RequirementData> = requirementApi.getAll().data

    suspend fun getById(id: Int) : Requirement = requirementApi.getById(id)

    suspend fun save(requirement: Requirement) = requirementApi.save(requirement)

    suspend fun update(id: Int, requirement: Requirement) : Requirement = requirementApi.update(id , requirement)

    suspend fun delete(id: Int) {

        val deletingRequirement = getById(id)
        deletingRequirement.data.attributes.confirmed = false

        update(id, deletingRequirement)
    }

}