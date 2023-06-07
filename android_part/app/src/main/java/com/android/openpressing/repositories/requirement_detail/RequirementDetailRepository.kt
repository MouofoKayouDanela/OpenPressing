package com.android.openpressing.repositories.requirement_detail

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.data.models.requirement_detail.RequirementDetail
import com.android.openpressing.data.models.requirement_detail.RequirementDetailData
import com.android.openpressing.data.models.requirement_detail.RequirementDetailInfo
import com.android.openpressing.data.models.requirement_detail.RequirementDetailInfoData
import retrofit2.Response
import javax.inject.Inject

class RequirementDetailRepository @Inject constructor(
    private val requirementDetailsApi : OpenPressingStrapiApi.RequirementDetailsApi
) {
    suspend fun getAll() : MutableList<RequirementDetailData> = requirementDetailsApi.getAll().data

    suspend fun getById(id: Int) : RequirementDetail = requirementDetailsApi.getById(id)

    suspend fun save(requirementDetail : RequirementDetailInfo) = requirementDetailsApi.save(requirementDetail)

    suspend fun update(
        id: Int,
        requirementDetail : RequirementDetailInfo
    ) = requirementDetailsApi.update(id , requirementDetail)

    suspend fun delete(id: Int) : Response<RequirementDetailInfo> {

        val deletingRequirementDetail = getById(id)

        return update(
                id,
                RequirementDetailInfo(
                        RequirementDetailInfoData(
                                id = deletingRequirementDetail.data.id,
                                laundry = deletingRequirementDetail.data.attributes.laundry.data.id!!,
                                service = deletingRequirementDetail.data.attributes.service.data.id!!,
                                quantity = deletingRequirementDetail.data.attributes.quantity,
                                unitPrice = deletingRequirementDetail.data.attributes.unitPrice,
                                confirmed = false
                        )
                )
        )
    }
}