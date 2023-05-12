package com.android.openpressing.viewmodels.services.state

import com.android.openpressing.data.models.service_category.ServiceCategoryData
import com.android.openpressing.data.models.service_type.ServiceType
import com.android.openpressing.data.models.service_type.ServiceTypeData

sealed class Service_typeState{

    object Empty: Service_typeState()
    object  Loading: Service_typeState()
    class  Success(val data: MutableList<ServiceTypeData >): Service_typeState()
    class Error(val message: String): Service_typeState()
}


