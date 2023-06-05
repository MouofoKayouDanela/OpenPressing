package com.android.openpressing.utils

const val BASE_URL = "http://192.168.114.94:1337"
const val API_FEATURES = "/api"
const val INCLUSION_FEATURES = "?filters[blocked][\$eq]=false&filters[confirmed][\$eq]=true&populate=*"
const val POPULATE = "?populate=*"

const val ADMINISTRATOR_FEATURES = "$API_FEATURES/administrateurs"
const val AGENCY_FEATURES = "$API_FEATURES/agencies"
const val AGENCY_LAUNDRY_FEATURES = "$API_FEATURES/agency-laundries"
const val AGENCY_SERVICE_FEATURES = "$API_FEATURES/agency-services"
const val AGENT_FEATURES = "$API_FEATURES/agents"
const val ANNONCE_FEATURES = "$API_FEATURES/annonces"
const val CITY_FEATURES = "$API_FEATURES/cities"
const val CLIENT_FEATURES = "$API_FEATURES/clients"
const val COUNTRY_FEATURES = "$API_FEATURES/countries"
const val LAUNDRY_FEATURES = "$API_FEATURES/laundries"
const val LAUNDRY_CATEGORIE_FEATURES = "$API_FEATURES/laundry-categories"
const val LAUNDRY_TYPE_FEATURES = "$API_FEATURES/laundry-types"
const val MESSAGE_FEATURES = "$API_FEATURES/messages"
const val OFFER_FEATURES = "$API_FEATURES/offers"
const val ORDER_FEATURES = "$API_FEATURES/orders"
const val OWNER_FEATURES = "$API_FEATURES/proprietaires"
const val PRESSING_FEATURES = "$API_FEATURES/pressings"
const val PRIVILEGE_FEATURES = "$API_FEATURES/priveleges"
const val PROMOTION_FEATURES = "$API_FEATURES/promotions"
const val QUARTER_FEATURES = "$API_FEATURES/quarters"
const val REQUIREMENT_FEATURES = "$API_FEATURES/besoins"
const val REQUIREMENT_DETAIL_FEATURES = "$API_FEATURES/requirement-details"
const val SERVICE_FEATURES = "$API_FEATURES/services"
const val SERVICE_CATEGORY_FEATURES = "$API_FEATURES/service-categories"
const val SERVICE_TYPE_FEATURES = "$API_FEATURES/service-types"
const val USER_FEATURES = "$API_FEATURES/users"