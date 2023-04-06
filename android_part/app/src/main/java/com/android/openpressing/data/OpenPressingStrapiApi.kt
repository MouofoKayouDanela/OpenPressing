package com.android.openpressing.data

import com.android.openpressing.data.models.City
import retrofit2.http.GET

sealed interface OpenPressingStrapiApi{

    interface CityApi: OpenPressingStrapiApi {
        @GET
        suspend fun getAllCities() : List<City>
    }

    interface CountryApi: OpenPressingStrapiApi {

    }

    interface ClientApi: OpenPressingStrapiApi {

    }

    interface LaundryApi: OpenPressingStrapiApi {

    }

    interface OfferApi: OpenPressingStrapiApi {

    }

    interface  OrderApi: OpenPressingStrapiApi {

    }

    interface QuarterApi: OpenPressingStrapiApi {

    }

    interface RequirementApi: OpenPressingStrapiApi {

    }

    interface RequirementDetailsApi: OpenPressingStrapiApi {

    }

    interface ServiceApi: OpenPressingStrapiApi {

    }

}