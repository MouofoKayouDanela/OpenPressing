package com.android.openpressing.data

import com.android.openpressing.data.models.*
import com.android.openpressing.data.models.administrator.Administrator
import com.android.openpressing.data.models.administrator.Administrators
import com.android.openpressing.data.models.agency.Agencies
import com.android.openpressing.data.models.agency.Agency
import com.android.openpressing.data.models.agency_laundry.AgencyLaundries
import com.android.openpressing.data.models.agency_laundry.AgencyLaundry
import com.android.openpressing.data.models.agency_service.AgencyService
import com.android.openpressing.data.models.agency_service.AgencyServices
import com.android.openpressing.data.models.agent.Agent
import com.android.openpressing.data.models.agent.Agents
import com.android.openpressing.data.models.annonce.Announce
import com.android.openpressing.data.models.annonce.Announces
import com.android.openpressing.data.models.city.Cities
import com.android.openpressing.data.models.city.City
import com.android.openpressing.data.models.client.Client
import com.android.openpressing.data.models.client.Clients
import com.android.openpressing.data.models.country.Countries
import com.android.openpressing.data.models.country.Country
import com.android.openpressing.data.models.laundry.Laundries
import com.android.openpressing.data.models.laundry.Laundry
import com.android.openpressing.data.models.laundry_category.LaundryCategories
import com.android.openpressing.data.models.laundry_category.LaundryCategory
import com.android.openpressing.data.models.laundry_type.LaundryType
import com.android.openpressing.data.models.laundry_type.LaundryTypes
import com.android.openpressing.data.models.message.Message
import com.android.openpressing.data.models.message.Messages
import com.android.openpressing.data.models.offer.Offer
import com.android.openpressing.data.models.offer.Offers
import com.android.openpressing.data.models.order.Order
import com.android.openpressing.data.models.order.Orders
import com.android.openpressing.data.models.owner.Owner
import com.android.openpressing.data.models.owner.Owners
import com.android.openpressing.data.models.pressing.Pressing
import com.android.openpressing.data.models.pressing.Pressings
import com.android.openpressing.data.models.privilege.Privilege
import com.android.openpressing.data.models.privilege.Privileges
import com.android.openpressing.data.models.promotion.Promotion
import com.android.openpressing.data.models.promotion.Promotions
import com.android.openpressing.data.models.quarter.Quarter
import com.android.openpressing.data.models.quarter.Quarters
import com.android.openpressing.data.models.requirement.Requirement
import com.android.openpressing.data.models.requirement.Requirements
import com.android.openpressing.data.models.requirement_detail.RequirementDetail
import com.android.openpressing.data.models.requirement_detail.RequirementDetails
import com.android.openpressing.data.models.service.Service
import com.android.openpressing.data.models.service.Services
import com.android.openpressing.data.models.service_category.ServiceCategories
import com.android.openpressing.data.models.service_category.ServiceCategory
import com.android.openpressing.data.models.service_type.ServiceType
import com.android.openpressing.data.models.service_type.ServiceTypes
import com.android.openpressing.data.models.user.User
import com.android.openpressing.utils.*
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

sealed interface OpenPressingStrapiApi{

    interface AdministratorApi: OpenPressingStrapiApi {

        @GET(ADMINISTRATOR_FEATURES + INCLUSION_FEATURES)
        suspend fun getAll() : Administrators

        @GET("$ADMINISTRATOR_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Administrator

        @POST(ADMINISTRATOR_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(administrator: Administrator)

        @PUT(ADMINISTRATOR_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(administrator: Administrator)

        @DELETE(ADMINISTRATOR_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(administrator: Administrator)
    }

    interface AgencyApi: OpenPressingStrapiApi {

        @GET(AGENCY_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Agencies

        @GET("$AGENCY_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Agency

        @POST(AGENCY_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(agency: Agency)

        @PUT(AGENCY_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(agency: Agency)

        @DELETE(AGENCY_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(agency: Agency)
    }

    interface AgencyLaundryApi: OpenPressingStrapiApi {

        @GET(AGENCY_LAUNDRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : AgencyLaundries

        @GET("$AGENCY_LAUNDRY_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : AgencyLaundry

        @POST(AGENCY_LAUNDRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(agencyLaundry: AgencyLaundry)

        @PUT(AGENCY_LAUNDRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(agencyLaundry: AgencyLaundry)

        @DELETE(AGENCY_LAUNDRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(agencyLaundry: AgencyLaundry)
    }

    interface AgencyServiceApi: OpenPressingStrapiApi {

        @GET(AGENCY_SERVICE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : AgencyServices

        @GET("$AGENCY_SERVICE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : AgencyService

        @POST(AGENCY_SERVICE_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(agencyService: AgencyService)

        @PUT(AGENCY_SERVICE_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(agencyService: AgencyService)

        @DELETE(AGENCY_SERVICE_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(agencyService: AgencyService)
    }

    interface AgentApi: OpenPressingStrapiApi {

        @GET(AGENT_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Agents

        @GET("$AGENT_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Agent

        @POST(AGENT_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(agent: Agent)

        @PUT(AGENT_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(agent: Agent)

        @DELETE(AGENT_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(agent: Agent)
    }

    interface AnnonceApi: OpenPressingStrapiApi {

        @GET(ANNONCE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Announces

        @GET("$ANNONCE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Announce

        @POST(ANNONCE_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(announce: Announce)

        @PUT(ANNONCE_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(announce: Announce)

        @DELETE(ANNONCE_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(announce: Announce)
    }

    interface CityApi: OpenPressingStrapiApi {

        @GET(CITY_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Cities

        @GET("$CITY_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : City

        @POST(CITY_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(city: City)

        @PUT(CITY_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(city: City)

        @DELETE(CITY_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(city: City)

    }

    interface CountryApi: OpenPressingStrapiApi {

        @GET(COUNTRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Countries

        @GET("$COUNTRY_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Country

        @POST(COUNTRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun  save(country: Country)

        @PUT(COUNTRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun  update(country: Country)

        @DELETE(COUNTRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(country: Country)
    }

    interface ClientApi: OpenPressingStrapiApi {

        @GET(CLIENT_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Clients

        @GET("$CLIENT_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Client

        @POST(CLIENT_FEATURES+ INCLUSION_FEATURES)
        suspend fun  save(client: Client)

        @PUT(CLIENT_FEATURES+ INCLUSION_FEATURES)
        suspend fun  update(client: Client)

        @DELETE(CLIENT_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(client: Client)
    }

    interface LaundryApi: OpenPressingStrapiApi {

        @GET(LAUNDRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Laundries

        @GET("$LAUNDRY_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Laundry

        @POST(LAUNDRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun  save(laundry: Laundry)

        @PUT(LAUNDRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun  update(laundry: Laundry)

        @DELETE(LAUNDRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(laundry: Laundry)
    }

    interface LaundryCategoryApi: OpenPressingStrapiApi {

        @GET(LAUNDRY_CATEGORIE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : LaundryCategories

        @GET("$LAUNDRY_CATEGORIE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : LaundryCategory

        @POST(LAUNDRY_CATEGORIE_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(laundryCategory: LaundryCategory)

        @PUT(LAUNDRY_CATEGORIE_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(laundryCategory: LaundryCategory)

        @DELETE(LAUNDRY_CATEGORIE_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(laundryCategory: LaundryCategory)
    }

    interface LaundryTypeApi: OpenPressingStrapiApi {

        @GET(LAUNDRY_TYPE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : LaundryTypes

        @GET("$LAUNDRY_TYPE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : LaundryType

        @POST(LAUNDRY_TYPE_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(laundryType: LaundryType)

        @PUT(LAUNDRY_TYPE_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(laundryType: LaundryType)

        @DELETE(LAUNDRY_TYPE_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(laundryType: LaundryType)
    }

    interface MessageApi: OpenPressingStrapiApi {

        @GET(MESSAGE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Messages

        @GET("$MESSAGE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Message

        @POST(MESSAGE_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(message: Message)

        @PUT(MESSAGE_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(message: Message)

        @DELETE(MESSAGE_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(message: Message)
    }

    interface OfferApi: OpenPressingStrapiApi {

        @GET(OFFER_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Offers

        @GET("$OFFER_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Offer

        @POST(OFFER_FEATURES+ INCLUSION_FEATURES)
        suspend fun  save(offer: Offer)

        @PUT(OFFER_FEATURES+ INCLUSION_FEATURES)
        suspend fun  update(offer: Offer)

        @DELETE(OFFER_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(offer: Offer)
    }

    interface  OrderApi: OpenPressingStrapiApi {

        @GET(ORDER_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Orders

        @GET("$ORDER_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Order

        @POST(ORDER_FEATURES+ INCLUSION_FEATURES)
        suspend fun  save(order: Order)

        @PUT(ORDER_FEATURES+ INCLUSION_FEATURES)
        suspend fun  update(order: Order)

        @DELETE(ORDER_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(order: Order)
    }

    interface OwnerApi: OpenPressingStrapiApi {

        @GET(OWNER_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Owners

        @GET("$OWNER_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Owner

        @POST(OWNER_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(owner: Owner)

        @PUT(OWNER_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(owner: Owner)

        @DELETE(OWNER_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(owner: Owner)
    }

    interface PressingApi: OpenPressingStrapiApi {

        @GET(PRESSING_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Pressings

        @GET("$PRESSING_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Pressing

        @POST(PRESSING_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(pressing: Pressing)

        @PUT(PRESSING_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(pressing: Pressing)

        @DELETE(PRESSING_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(pressing: Pressing)
    }

    interface PrivilegeApi: OpenPressingStrapiApi {

        @GET(PRIVILEGE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Privileges

        @GET("$PRIVILEGE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Privilege

        @POST(PRIVILEGE_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(privilege: Privilege)

        @PUT(PRIVILEGE_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(privilege: Privilege)

        @DELETE(PRIVILEGE_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(privilege: Privilege)
    }

    interface PromotionApi: OpenPressingStrapiApi {

        @GET(PROMOTION_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Promotions

        @GET("$PROMOTION_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Promotion

        @POST(PROMOTION_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(promotion: Promotion)

        @PUT(PROMOTION_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(promotion: Promotion)

        @DELETE(PROMOTION_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(promotion: Promotion)
    }

    interface QuarterApi: OpenPressingStrapiApi {

        @GET(QUARTER_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Quarters

        @GET("$QUARTER_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Quarter

        @POST(QUARTER_FEATURES+ INCLUSION_FEATURES)
        suspend fun  save(quarter: Quarter)

        @PUT(QUARTER_FEATURES+ INCLUSION_FEATURES)
        suspend fun  update(quarter: Quarter)

        @DELETE(QUARTER_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(quarter: Quarter)
    }

    interface RequirementApi: OpenPressingStrapiApi {

        @GET(REQUIREMENT_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Requirements

        @GET("$QUARTER_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Requirement

        @POST(QUARTER_FEATURES+ INCLUSION_FEATURES)
        suspend fun  save(requirement: Requirement)

        @PUT(QUARTER_FEATURES+ INCLUSION_FEATURES)
        suspend fun  update(requirement: Requirement)

        @DELETE(QUARTER_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(requirement: Requirement)
    }

    interface RequirementDetailsApi: OpenPressingStrapiApi {

        @GET(REQUIREMENT_DETAIL_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : RequirementDetails

        @GET("$REQUIREMENT_DETAIL_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : RequirementDetail

        @POST(REQUIREMENT_DETAIL_FEATURES+ INCLUSION_FEATURES)
        suspend fun  save(requirementDetail: RequirementDetail)

        @PUT(REQUIREMENT_DETAIL_FEATURES+ INCLUSION_FEATURES)
        suspend fun  update(requirementDetail: RequirementDetail)

        @DELETE(REQUIREMENT_DETAIL_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(requirementDetail: RequirementDetail)
    }

    interface ServiceApi: OpenPressingStrapiApi {

        @GET(SERVICE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Services

        @GET("$SERVICE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Service

        @POST(SERVICE_FEATURES+ INCLUSION_FEATURES)
        suspend fun  save(service: Service)

        @PUT(SERVICE_FEATURES+ INCLUSION_FEATURES)
        suspend fun  update(service: Service)

        @DELETE(SERVICE_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(service: Service)
    }

    interface ServiceCategoryApi: OpenPressingStrapiApi {

        @GET(SERVICE_CATEGORY_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : ServiceCategories

        @GET("$SERVICE_CATEGORY_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : ServiceCategory

        @POST(SERVICE_CATEGORY_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(serviceCategory: ServiceCategory)

        @PUT(SERVICE_CATEGORY_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(serviceCategory: ServiceCategory)

        @DELETE(SERVICE_CATEGORY_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(serviceCategory: ServiceCategory)
    }

    interface ServiceTypeApi: OpenPressingStrapiApi {

        @GET(SERVICE_TYPE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : ServiceTypes

        @GET("$SERVICE_TYPE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : ServiceType

        @POST(SERVICE_TYPE_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(serviceType: ServiceType)

        @PUT(SERVICE_TYPE_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(serviceType: ServiceType)

        @DELETE(SERVICE_TYPE_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(serviceType: ServiceType)
    }

    interface UserApi: OpenPressingStrapiApi {

        @GET(USER_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : List<User>

        @GET("$USER_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : User

        @POST(USER_FEATURES+ INCLUSION_FEATURES)
        suspend fun save(user: User)

        @PUT(USER_FEATURES+ INCLUSION_FEATURES)
        suspend fun update(user: User)

        @DELETE(USER_FEATURES+ INCLUSION_FEATURES)
        suspend fun delete(user: User)
    }

}