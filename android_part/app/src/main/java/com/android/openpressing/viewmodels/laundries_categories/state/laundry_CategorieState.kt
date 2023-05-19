package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.laundry_category.LaundryCategoryData
import com.android.openpressing.data.models.pressing.PressingData

sealed class laundry_CategorieState{

    object Empty: laundry_CategorieState()
    object  Loading: laundry_CategorieState()
    class  Success(val data: MutableList<LaundryCategoryData>): laundry_CategorieState()
    class Error(val message: String):laundry_CategorieState()
}


