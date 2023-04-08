package com.android.openpressing.data

import com.android.openpressing.data.models.*
import com.android.openpressing.utils.*
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

sealed interface OpenPressingStrapiApi{

    interface AdministratorApi: OpenPressingStrapiApi {

        @GET(ADMINISTRATOR_FEATURES)
        suspend fun getAll() : List<Administrator>

        @GET(ADMINISTRATOR_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Administrator

        @POST(ADMINISTRATOR_FEATURES)
        suspend fun save(administrator: Administrator)

        @PUT(ADMINISTRATOR_FEATURES)
        suspend fun update(administrator: Administrator)

        @DELETE(ADMINISTRATOR_FEATURES)
        suspend fun delete(administrator: Administrator)
    }

    interface AgencyApi: OpenPressingStrapiApi {

        @GET(AGENCY_FEATURES)
        suspend fun getAll() : List<Agency>

        @GET(AGENCY_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Agency

        @POST(AGENCY_FEATURES)
        suspend fun save(agency: Agency)

        @PUT(AGENCY_FEATURES)
        suspend fun update(agency: Agency)

        @DELETE(AGENCY_FEATURES)
        suspend fun delete(agency: Agency)
    }

    interface AgencyLaundryApi: OpenPressingStrapiApi {

        @GET(AGENCY_LAUNDRY_FEATURES)
        suspend fun getAll() : List<Agency_Laundry>

        @GET(AGENCY_LAUNDRY_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Agency_Laundry

        @POST(AGENCY_LAUNDRY_FEATURES)
        suspend fun save(agencyLaundry: Agency_Laundry)

        @PUT(AGENCY_LAUNDRY_FEATURES)
        suspend fun update(agencyLaundry: Agency_Laundry)

        @DELETE(AGENCY_LAUNDRY_FEATURES)
        suspend fun delete(agencyLaundry: Agency_Laundry)
    }

    interface AgencyServiceApi: OpenPressingStrapiApi {

        @GET(AGENCY_SERVICE_FEATURES)
        suspend fun getAll() : List<Agency_Service>

        @GET(AGENCY_SERVICE_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Agency_Service

        @POST(AGENCY_SERVICE_FEATURES)
        suspend fun save(agencyService: Agency_Service)

        @PUT(AGENCY_SERVICE_FEATURES)
        suspend fun update(agencyService: Agency_Service)

        @DELETE(AGENCY_SERVICE_FEATURES)
        suspend fun delete(agencyService: Agency_Service)
    }

    interface AgentApi: OpenPressingStrapiApi {

        @GET(AGENT_FEATURES)
        suspend fun getAll() : List<Agent>

        @GET(AGENT_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Agent

        @POST(AGENT_FEATURES)
        suspend fun save(agent: Agent)

        @PUT(AGENT_FEATURES)
        suspend fun update(agent: Agent)

        @DELETE(AGENT_FEATURES)
        suspend fun delete(agent: Agent)
    }

    interface AnnonceApi: OpenPressingStrapiApi {

        @GET(ANNONCE_FEATURES)
        suspend fun getAll() : List<Annonce>

        @GET(ANNONCE_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Annonce

        @POST(ANNONCE_FEATURES)
        suspend fun save(annonce: Annonce)

        @PUT(ANNONCE_FEATURES)
        suspend fun update(annonce: Annonce)

        @DELETE(ANNONCE_FEATURES)
        suspend fun delete(annonce: Annonce)
    }

    interface CityApi: OpenPressingStrapiApi {

        @GET(CITY_FEATURES)
        suspend fun getAll() : List<City>

        @GET(CITY_FEATURES)
        suspend fun getById(@Query("q") id: Int) : City

        @POST(CITY_FEATURES)
        suspend fun save(city: City)

        @PUT(CITY_FEATURES)
        suspend fun update(city: City)

        @DELETE(CITY_FEATURES)
        suspend fun delete(city: City)

    }

    interface CountryApi: OpenPressingStrapiApi {

        @GET(COUNTRY_FEATURES)
        suspend fun getAll() : List<Country>

        @GET(COUNTRY_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Country

        @POST(COUNTRY_FEATURES)
        suspend fun  save(country: Country)

        @PUT(COUNTRY_FEATURES)
        suspend fun  update(country: Country)

        @DELETE(COUNTRY_FEATURES)
        suspend fun delete(country: Country)
    }

    interface ClientApi: OpenPressingStrapiApi {

        @GET(CLIENT_FEATURES)
        suspend fun getAll() : List<Client>

        @GET(CLIENT_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Client

        @POST(CLIENT_FEATURES)
        suspend fun  save(client: Client)

        @PUT(CLIENT_FEATURES)
        suspend fun  update(client: Client)

        @DELETE(CLIENT_FEATURES)
        suspend fun delete(client: Client)
    }

    interface LaundryApi: OpenPressingStrapiApi {

        @GET(LAUNDRY_FEATURES)
        suspend fun getAll() : List<Laundry>

        @GET(LAUNDRY_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Laundry

        @POST(LAUNDRY_FEATURES)
        suspend fun  save(laundry: Laundry)

        @PUT(LAUNDRY_FEATURES)
        suspend fun  update(laundry: Laundry)

        @DELETE(LAUNDRY_FEATURES)
        suspend fun delete(laundry: Laundry)
    }

    interface LaundryCategoryApi: OpenPressingStrapiApi {

        @GET(LAUNDRY_CATEGORIE_FEATURES)
        suspend fun getAll() : List<Laundry_Category>

        @GET(LAUNDRY_CATEGORIE_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Laundry_Category

        @POST(LAUNDRY_CATEGORIE_FEATURES)
        suspend fun save(laundryCategorie: Laundry_Category)

        @PUT(LAUNDRY_CATEGORIE_FEATURES)
        suspend fun update(laundryCategorie: Laundry_Category)

        @DELETE(LAUNDRY_CATEGORIE_FEATURES)
        suspend fun delete(laundryCategorie: Laundry_Category)
    }

    interface LaundryTypeApi: OpenPressingStrapiApi {

        @GET(LAUNDRY_TYPE_FEATURES)
        suspend fun getAll() : List<Laundry_Type>

        @GET(LAUNDRY_TYPE_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Laundry_Type

        @POST(LAUNDRY_TYPE_FEATURES)
        suspend fun save(laundryType: Laundry_Type)

        @PUT(LAUNDRY_TYPE_FEATURES)
        suspend fun update(laundryType: Laundry_Type)

        @DELETE(LAUNDRY_TYPE_FEATURES)
        suspend fun delete(laundryType: Laundry_Type)
    }

    interface MessageApi: OpenPressingStrapiApi {

        @GET(MESSAGE_FEATURES)
        suspend fun getAll() : List<Message>

        @GET(MESSAGE_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Message

        @POST(MESSAGE_FEATURES)
        suspend fun save(message: Message)

        @PUT(MESSAGE_FEATURES)
        suspend fun update(message: Message)

        @DELETE(MESSAGE_FEATURES)
        suspend fun delete(message: Message)
    }

    interface OfferApi: OpenPressingStrapiApi {

        @GET(OFFER_FEATURES)
        suspend fun getAll() : List<Offer>

        @GET(OFFER_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Offer

        @POST(OFFER_FEATURES)
        suspend fun  save(offer: Offer)

        @PUT(OFFER_FEATURES)
        suspend fun  update(offer: Offer)

        @DELETE(OFFER_FEATURES)
        suspend fun delete(offer: Offer)
    }

    interface  OrderApi: OpenPressingStrapiApi {

        @GET(ORDER_FEATURES)
        suspend fun getAll() : List<Order>

        @GET(ORDER_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Order

        @POST(ORDER_FEATURES)
        suspend fun  save(order: Order)

        @PUT(ORDER_FEATURES)
        suspend fun  update(order: Order)

        @DELETE(ORDER_FEATURES)
        suspend fun delete(order: Order)
    }

    interface OwnerApi: OpenPressingStrapiApi {

        @GET(OWNER_FEATURES)
        suspend fun getAll() : List<Owner>

        @GET(OWNER_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Owner

        @POST(OWNER_FEATURES)
        suspend fun save(owner: Owner)

        @PUT(OWNER_FEATURES)
        suspend fun update(owner: Owner)

        @DELETE(OWNER_FEATURES)
        suspend fun delete(owner: Owner)
    }

    interface PressingApi: OpenPressingStrapiApi {

        @GET(PRESSING_FEATURES)
        suspend fun getAll() : List<Pressing>

        @GET(PRESSING_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Pressing

        @POST(PRESSING_FEATURES)
        suspend fun save(pressing: Pressing)

        @PUT(PRESSING_FEATURES)
        suspend fun update(pressing: Pressing)

        @DELETE(PRESSING_FEATURES)
        suspend fun delete(pressing: Pressing)
    }

    interface PrivilegeApi: OpenPressingStrapiApi {

        @GET(PRIVILEGE_FEATURES)
        suspend fun getAll() : List<Privilege>

        @GET(PRIVILEGE_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Privilege

        @POST(PRIVILEGE_FEATURES)
        suspend fun save(privilege: Privilege)

        @PUT(PRIVILEGE_FEATURES)
        suspend fun update(privilege: Privilege)

        @DELETE(PRIVILEGE_FEATURES)
        suspend fun delete(privilege: Privilege)
    }

    interface PromotionApi: OpenPressingStrapiApi {

        @GET(PROMOTION_FEATURES)
        suspend fun getAll() : List<Promotion>

        @GET(PROMOTION_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Promotion

        @POST(PROMOTION_FEATURES)
        suspend fun save(promotion: Promotion)

        @PUT(PROMOTION_FEATURES)
        suspend fun update(promotion: Promotion)

        @DELETE(PROMOTION_FEATURES)
        suspend fun delete(promotion: Promotion)
    }

    interface QuarterApi: OpenPressingStrapiApi {

        @GET(QUARTER_FEATURES)
        suspend fun getAll() : List<Quarter>

        @GET(QUARTER_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Quarter

        @POST(QUARTER_FEATURES)
        suspend fun  save(quarter: Quarter)

        @PUT(QUARTER_FEATURES)
        suspend fun  update(quarter: Quarter)

        @DELETE(QUARTER_FEATURES)
        suspend fun delete(quarter: Quarter)
    }

    interface RequirementApi: OpenPressingStrapiApi {

        @GET(REQUIREMENT_FEATURES)
        suspend fun getAll() : List<Requirement>

        @GET(QUARTER_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Requirement

        @POST(QUARTER_FEATURES)
        suspend fun  save(requirement: Requirement)

        @PUT(QUARTER_FEATURES)
        suspend fun  update(requirement: Requirement)

        @DELETE(QUARTER_FEATURES)
        suspend fun delete(requirement: Requirement)
    }

    interface RequirementDetailsApi: OpenPressingStrapiApi {

        @GET(REQUIREMENT_DETAIL_FEATURES)
        suspend fun getAll() : List<Requirement_Detail>

        @GET(REQUIREMENT_DETAIL_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Requirement_Detail

        @POST(REQUIREMENT_DETAIL_FEATURES)
        suspend fun  save(requirementDetail: Requirement_Detail)

        @PUT(REQUIREMENT_DETAIL_FEATURES)
        suspend fun  update(requirementDetail: Requirement_Detail)

        @DELETE(REQUIREMENT_DETAIL_FEATURES)
        suspend fun delete(requirementDetail: Requirement_Detail)
    }

    interface ServiceApi: OpenPressingStrapiApi {

        @GET(SERVICE_FEATURES)
        suspend fun getAll() : List<Service>

        @GET(SERVICE_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Service

        @POST(SERVICE_FEATURES)
        suspend fun  save(service: Service)

        @PUT(SERVICE_FEATURES)
        suspend fun  update(service: Service)

        @DELETE(SERVICE_FEATURES)
        suspend fun delete(service: Service)
    }

    interface ServiceCategoryApi: OpenPressingStrapiApi {

        @GET(SERVICE_CATEGORY_FEATURES)
        suspend fun getAll() : List<Service_Category>

        @GET(SERVICE_CATEGORY_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Service_Category

        @POST(SERVICE_CATEGORY_FEATURES)
        suspend fun save(serviceCategory: Service_Category)

        @PUT(SERVICE_CATEGORY_FEATURES)
        suspend fun update(serviceCategory: Service_Category)

        @DELETE(SERVICE_CATEGORY_FEATURES)
        suspend fun delete(serviceCategory: Service_Category)
    }

    interface ServiceTypeApi: OpenPressingStrapiApi {

        @GET(SERVICE_TYPE_FEATURES)
        suspend fun getAll() : List<Service_Type>

        @GET(SERVICE_TYPE_FEATURES)
        suspend fun getById(@Query("q") id: Int) : Service_Type

        @POST(SERVICE_TYPE_FEATURES)
        suspend fun save(serviceType: Service_Type)

        @PUT(SERVICE_TYPE_FEATURES)
        suspend fun update(serviceType: Service_Type)

        @DELETE(SERVICE_TYPE_FEATURES)
        suspend fun delete(serviceType: Service_Type)
    }

    interface UserApi: OpenPressingStrapiApi {

        @GET(USER_FEATURES)
        suspend fun getAll() : List<User>

        @GET(USER_FEATURES)
        suspend fun getById(@Query("q") id: Int) : User

        @POST(USER_FEATURES)
        suspend fun save(user: User)

        @PUT(USER_FEATURES)
        suspend fun update(user: User)

        @DELETE(USER_FEATURES)
        suspend fun delete(user: User)
    }

}