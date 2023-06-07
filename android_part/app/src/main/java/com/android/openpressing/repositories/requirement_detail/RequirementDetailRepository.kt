package com.android.openpressing.repositories.requirement_detail

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.requirement_detail.RequirementDetail
import com.android.openpressing.data.models.requirement_detail.RequirementDetailData
import javax.inject.Inject

class RequirementDetailRepository @Inject constructor(
    private val requirementDetailsApi : OpenPressingStrapiApi.RequirementDetailsApi
) {
    suspend fun getAll() : MutableList<RequirementDetailData> = requirementDetailsApi.getAll().data

    suspend fun getById(id: Int) : RequirementDetail = requirementDetailsApi.getById(id)

    suspend fun save(requirementDetail : RequirementDetail) = requirementDetailsApi.save(requirementDetail)

    suspend fun update(id: Int,requirementDetail : RequirementDetail) : RequirementDetail = requirementDetailsApi.update(id , requirementDetail)

    suspend fun delete(id: Int) {

        val deletingRequirementDetail = getById(id)
        deletingRequirementDetail.data.attributes.confirmed = false

        update(id, deletingRequirementDetail)
    }
}