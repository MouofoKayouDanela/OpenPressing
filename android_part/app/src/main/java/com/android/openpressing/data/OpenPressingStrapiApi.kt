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
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.*

sealed interface OpenPressingStrapiApi{

    interface AdministratorApi: OpenPressingStrapiApi {

        @GET(ADMINISTRATOR_FEATURES + INCLUSION_FEATURES)
        suspend fun getAll() : Administrators

        @GET("$ADMINISTRATOR_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(
            @Path("id") id: Int
        ) : Administrator

        @POST(ADMINISTRATOR_FEATURES)
        suspend fun save(
            @Body administrator: Administrator
        )

        @PUT("$ADMINISTRATOR_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body administrator: Administrator
        ) : Administrator

//        @DELETE("$ADMINISTRATOR_FEATURES/{id}")
//        suspend fun delete(
//            administrator: Administrator
//        )
    }

    interface AgencyApi: OpenPressingStrapiApi {

        @GET(AGENCY_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Agencies

        @GET("$AGENCY_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Agency

        @POST(AGENCY_FEATURES)
        suspend fun save(
            @Body agency: Agency
        )

        @PUT("$AGENCY_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body agency: Agency
        ) : Agency

//        @DELETE(AGENCY_FEATURES+ INCLUSION_FEATURES)
//        suspend fun delete(agency: Agency)
    }

    interface AgencyLaundryApi: OpenPressingStrapiApi {

        @GET(AGENCY_LAUNDRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : AgencyLaundries

        @GET("$AGENCY_LAUNDRY_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : AgencyLaundry

        @POST(AGENCY_LAUNDRY_FEATURES)
        suspend fun save(
            @Body agencyLaundry: AgencyLaundry
        )

        @PUT("$AGENCY_LAUNDRY_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body agencyLaundry: AgencyLaundry
        ) : AgencyLaundry

//        @DELETE(AGENCY_LAUNDRY_FEATURES)
//        suspend fun delete(agencyLaundry: AgencyLaundry)
    }

    interface AgencyServiceApi: OpenPressingStrapiApi {

        @GET(AGENCY_SERVICE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : AgencyServices

        @GET("$AGENCY_SERVICE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : AgencyService

        @POST(AGENCY_SERVICE_FEATURES)
        suspend fun save(
            @Body agencyService: AgencyService
        )

        @PUT("$AGENCY_SERVICE_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body agencyService: AgencyService
        ) : AgencyService

//        @DELETE(AGENCY_SERVICE_FEATURES)
//        suspend fun delete(agencyService: AgencyService)
    }

    interface AgentApi: OpenPressingStrapiApi {

        @GET(AGENT_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Agents

        @GET("$AGENT_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Agent

        @POST(AGENT_FEATURES)
        suspend fun save(agent: Agent)

        @PUT("$AGENT_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body agent: Agent
        ) : Agent

//        @DELETE(AGENT_FEATURES)
//        suspend fun delete(agent: Agent)
    }

    interface AnnonceApi: OpenPressingStrapiApi {

        @GET(ANNONCE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Announces

        @GET("$ANNONCE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Announce

        @POST(ANNONCE_FEATURES)
        suspend fun save(announce: Announce)

        @PUT("$ANNONCE_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body announce: Announce
        ) : Announce

//        @DELETE(ANNONCE_FEATURES)
//        suspend fun delete(announce: Announce)
    }

    interface CityApi: OpenPressingStrapiApi {

        @GET(CITY_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Cities

        @GET("$CITY_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : City

        @POST(CITY_FEATURES)
        suspend fun save(
            @Body city: City
        )

        @PUT("$CITY_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body city: City
        ) : City

//        @DELETE(CITY_FEATURES)
//        suspend fun delete(city: City)

    }

    interface CountryApi: OpenPressingStrapiApi {

        @GET(COUNTRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Countries

        @GET("$COUNTRY_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Country

        @POST(COUNTRY_FEATURES)
        suspend fun  save(country: Country)

        @PUT("$COUNTRY_FEATURES/{id}")
        suspend fun  update(
            @Path("id") id: Int,
            @Body country: Country
        ) : Country

//        @DELETE(COUNTRY_FEATURES)
//        suspend fun delete(country: Country)
    }

    interface ClientApi: OpenPressingStrapiApi {

        @GET(CLIENT_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Clients

        @GET("$CLIENT_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Client

        @POST(CLIENT_FEATURES)
        suspend fun  save(
            @Body client: Client
        )

        @PUT("$CLIENT_FEATURES/{id}")
        suspend fun  update(
            @Path("id") id: Int,
            @Body client: Client
        ) : Client

//        @DELETE(CLIENT_FEATURES)
//        suspend fun delete(client: Client)
    }

    interface LaundryApi: OpenPressingStrapiApi {

        @GET(LAUNDRY_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Laundries

        @GET("$LAUNDRY_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Laundry

        @POST(LAUNDRY_FEATURES)
        suspend fun  save(
            @Body laundry: Laundry
        )

        @PUT("$LAUNDRY_FEATURES/{id}")
        suspend fun  update(
            @Path("id") id: Int,
            @Body laundry: Laundry
        ) : Laundry

//        @DELETE(LAUNDRY_FEATURES)
//        suspend fun delete(laundry: Laundry)
    }

    interface LaundryCategoryApi: OpenPressingStrapiApi {

        @GET(LAUNDRY_CATEGORIE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : LaundryCategories

        @GET("$LAUNDRY_CATEGORIE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : LaundryCategory

        @POST(LAUNDRY_CATEGORIE_FEATURES)
        suspend fun save(laundryCategory: LaundryCategory)

        @PUT("$LAUNDRY_CATEGORIE_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body laundryCategory: LaundryCategory
        ) : LaundryCategory

//        @DELETE(LAUNDRY_CATEGORIE_FEATURES)
//        suspend fun delete(laundryCategory: LaundryCategory)
    }

    interface LaundryTypeApi: OpenPressingStrapiApi {

        @GET(LAUNDRY_TYPE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : LaundryTypes

        @GET("$LAUNDRY_TYPE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : LaundryType

        @POST(LAUNDRY_TYPE_FEATURES)
        suspend fun save(
            @Body laundryType: LaundryType
        )

        @PUT("$LAUNDRY_TYPE_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body laundryType: LaundryType
        ) : LaundryType

//        @DELETE(LAUNDRY_TYPE_FEATURES)
//        suspend fun delete(laundryType: LaundryType)
    }

    interface MessageApi: OpenPressingStrapiApi {

        @GET(MESSAGE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Messages

        @GET("$MESSAGE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Message

        @POST(MESSAGE_FEATURES)
        suspend fun save(
            @Body message: Message
        )

        @PUT("$MESSAGE_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body message: Message
        ) : Message

//        @DELETE(MESSAGE_FEATURES)
//        suspend fun delete(message: Message)
    }

    interface OfferApi: OpenPressingStrapiApi {

        @GET(OFFER_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Offers

        @GET("$OFFER_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Offer

        @POST(OFFER_FEATURES)
        suspend fun  save(
            @Body offer: Offer
        )

        @PUT("$OFFER_FEATURES/{id}")
        suspend fun  update(
            @Path("id") id: Int,
            @Body offer: Offer
        ) : Offer

//        @DELETE(OFFER_FEATURES)
//        suspend fun delete(offer: Offer)
    }

    interface  OrderApi: OpenPressingStrapiApi {

        @GET(ORDER_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Orders

        @GET("$ORDER_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Order

        @POST(ORDER_FEATURES)
        suspend fun  save(
            @Body order: Order
        )

        @PUT("$ORDER_FEATURES/{id}")
        suspend fun  update(
            @Path("id") id: Int,
            @Body order: Order
        ) : Order

//        @DELETE(ORDER_FEATURES)
//        suspend fun delete(order: Order)
    }

    interface OwnerApi: OpenPressingStrapiApi {

        @GET(OWNER_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Owners

        @GET("$OWNER_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Owner

        @POST(OWNER_FEATURES)
        suspend fun save(
            @Body owner: Owner
        )

        @PUT("$OWNER_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body owner: Owner
        ) : Owner

//        @DELETE(OWNER_FEATURES)
//        suspend fun delete(owner: Owner)
    }

    interface PressingApi: OpenPressingStrapiApi {

        @GET(PRESSING_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Pressings

        @GET("$PRESSING_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Pressing

        @POST(PRESSING_FEATURES)
        suspend fun save(
            @Body pressing: Pressing
        )

        @PUT("$PRESSING_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body pressing: Pressing
        ) : Pressing

//        @DELETE(PRESSING_FEATURES)
//        suspend fun delete(pressing: Pressing)
    }

    interface PrivilegeApi: OpenPressingStrapiApi {

        @GET(PRIVILEGE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Privileges

        @GET("$PRIVILEGE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Privilege

        @POST(PRIVILEGE_FEATURES)
        suspend fun save(
            @Body privilege: Privilege
        )

        @PUT("$PRIVILEGE_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body privilege: Privilege
        ) : Privilege

//        @DELETE(PRIVILEGE_FEATURES)
//        suspend fun delete(privilege: Privilege)
    }

    interface PromotionApi: OpenPressingStrapiApi {

        @GET(PROMOTION_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Promotions

        @GET("$PROMOTION_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Promotion

        @POST(PROMOTION_FEATURES)
        suspend fun save(
            @Body promotion: Promotion
        )

        @PUT("$PROMOTION_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body promotion: Promotion
        ) : Promotion

//        @DELETE(PROMOTION_FEATURES)
//        suspend fun delete(promotion: Promotion)
    }

    interface QuarterApi: OpenPressingStrapiApi {

        @GET(QUARTER_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Quarters

        @GET("$QUARTER_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Quarter

        @POST(QUARTER_FEATURES)
        suspend fun  save(
            @Body quarter: Quarter
        )

        @PUT("$QUARTER_FEATURES/{id}")
        suspend fun  update(
            @Path("id") id: Int,
            @Body quarter: Quarter
        ) : Quarter

//        @DELETE(QUARTER_FEATURES)
//        suspend fun delete(quarter: Quarter)
    }

    interface RequirementApi: OpenPressingStrapiApi {

        @GET(REQUIREMENT_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Requirements

        @GET("$QUARTER_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Requirement

        @POST(QUARTER_FEATURES)
        suspend fun  save(
            @Body requirement: Requirement
        )

        @PUT("$QUARTER_FEATURES/{id}")
        suspend fun  update(
            @Path("id") id: Int,
            @Body requirement: Requirement
        ) : Requirement

//        @DELETE(QUARTER_FEATURES)
//        suspend fun delete(requirement: Requirement)
    }

    interface RequirementDetailsApi: OpenPressingStrapiApi {

        @GET(REQUIREMENT_DETAIL_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : RequirementDetails

        @GET("$REQUIREMENT_DETAIL_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : RequirementDetail

        @POST(REQUIREMENT_DETAIL_FEATURES)
        suspend fun  save(
            @Body requirementDetail: RequirementDetail
        )

        @PUT("$REQUIREMENT_DETAIL_FEATURES/{id}")
        suspend fun  update(
            @Path("id") id: Int,
            @Body requirementDetail: RequirementDetail
        ) : RequirementDetail

//        @DELETE(REQUIREMENT_DETAIL_FEATURES)
//        suspend fun delete(requirementDetail: RequirementDetail)
    }

    interface ServiceApi: OpenPressingStrapiApi {

        @GET(SERVICE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : Services

        @GET("$SERVICE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : Service

        @POST(SERVICE_FEATURES)
        suspend fun  save(
            @Body service: Service
        )

        @PUT("$SERVICE_FEATURES/{id}")
        suspend fun  update(
            @Path("id") id: Int,
            @Body service: Service
        ) : Service

//        @DELETE(SERVICE_FEATURES)
//        suspend fun delete(service: Service)
    }

    interface ServiceCategoryApi: OpenPressingStrapiApi {

        @GET(SERVICE_CATEGORY_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : ServiceCategories

        @GET("$SERVICE_CATEGORY_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : ServiceCategory

        @POST(SERVICE_CATEGORY_FEATURES)
        suspend fun save(
            @Body serviceCategory: ServiceCategory
        )

        @PUT("$SERVICE_CATEGORY_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body serviceCategory: ServiceCategory
        ) : ServiceCategory

//        @DELETE(SERVICE_CATEGORY_FEATURES)
//        suspend fun delete(serviceCategory: ServiceCategory)
    }

    interface ServiceTypeApi: OpenPressingStrapiApi {

        @GET(SERVICE_TYPE_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : ServiceTypes

        @GET("$SERVICE_TYPE_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : ServiceType

        @POST(SERVICE_TYPE_FEATURES)
        suspend fun save(
            @Body serviceType: ServiceType
        )

        @PUT("$SERVICE_TYPE_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body serviceType: ServiceType
        ) : ServiceType

//        @DELETE(SERVICE_TYPE_FEATURES)
//        suspend fun delete(serviceType: ServiceType)
    }

    interface UserApi: OpenPressingStrapiApi {

        @GET(USER_FEATURES+ INCLUSION_FEATURES)
        suspend fun getAll() : List<User>

        @GET("$USER_FEATURES/{id}$INCLUSION_FEATURES")
        suspend fun getById(@Path("id") id: Int) : User

        @POST(USER_FEATURES)
        suspend fun save(
            @Body user: User
        )

        @PUT("$USER_FEATURES/{id}")
        suspend fun update(
            @Path("id") id: Int,
            @Body user: User
        ) : User

//        @DELETE(USER_FEATURES)
//        suspend fun delete(user: User)
    }

}