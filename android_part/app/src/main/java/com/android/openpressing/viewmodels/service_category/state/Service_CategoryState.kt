package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.service_category.ServiceCategoryData

sealed class Service_CategoryState{

    object Empty: Service_typeState()
    object  Loading: Service_typeState()
    class  Success(val data: MutableList<ServiceCategoryData>): Service_typeState()
    class Error(val message: String): Service_typeState()
}


