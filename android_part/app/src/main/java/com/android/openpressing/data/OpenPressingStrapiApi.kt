package com.android.openpressing.data

sealed interface OpenPressingStrapiApi{

    interface CityApi: OpenPressingStrapiApi {

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