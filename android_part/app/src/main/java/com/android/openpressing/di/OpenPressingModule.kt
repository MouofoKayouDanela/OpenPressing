package com.android.openpressing.di

import com.android.openpressing.data.OpenPressingStrapiApi
import com.android.openpressing.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object OpenPressingModule{

    @Provides
    fun okHttp(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        return OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun retrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun administratorStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.AdministratorApi {
        return retrofit.create(OpenPressingStrapiApi.AdministratorApi::class.java)
    }

    @Provides
    fun agencyStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.AgencyApi {
        return retrofit.create(OpenPressingStrapiApi.AgencyApi::class.java)
    }

    @Provides
    fun agencyLaundryStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.AgencyLaundryApi {
        return retrofit.create(OpenPressingStrapiApi.AgencyLaundryApi::class.java)
    }

    @Provides
    fun agencyServiceStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.AgencyServiceApi {
        return retrofit.create(OpenPressingStrapiApi.AgencyServiceApi::class.java)
    }

    @Provides
    fun agentStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.AgentApi {
        return retrofit.create(OpenPressingStrapiApi.AgentApi::class.java)
    }

    @Provides
    fun annonceStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.AnnonceApi {
        return retrofit.create(OpenPressingStrapiApi.AnnonceApi::class.java)
    }

    @Provides
    fun cityStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.CityApi {
        return retrofit.create(OpenPressingStrapiApi.CityApi::class.java)
    }

    @Provides
    fun clientStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.ClientApi {
        return retrofit.create(OpenPressingStrapiApi.ClientApi::class.java)
    }

    @Provides
    fun countryStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.CountryApi {
        return retrofit.create(OpenPressingStrapiApi.CountryApi::class.java)
    }

    @Provides
    fun laundryStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.LaundryApi {
        return retrofit.create(OpenPressingStrapiApi.LaundryApi::class.java)
    }

    @Provides
    fun laundryCategoryStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.LaundryCategoryApi {
        return retrofit.create(OpenPressingStrapiApi.LaundryCategoryApi::class.java)
    }

    @Provides
    fun laundryTypeStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.LaundryTypeApi {
        return retrofit.create(OpenPressingStrapiApi.LaundryTypeApi::class.java)
    }

    @Provides
    fun messageStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.MessageApi {
        return retrofit.create(OpenPressingStrapiApi.MessageApi::class.java)
    }

    @Provides
    fun offerStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.OfferApi {
        return retrofit.create(OpenPressingStrapiApi.OfferApi::class.java)
    }

    @Provides
    fun orderStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.OrderApi {
        return retrofit.create(OpenPressingStrapiApi.OrderApi::class.java)
    }

    @Provides
    fun ownerStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.OwnerApi {
        return retrofit.create(OpenPressingStrapiApi.OwnerApi::class.java)
    }

    @Provides
    fun pressingStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.PressingApi {
        return retrofit.create(OpenPressingStrapiApi.PressingApi::class.java)
    }

    @Provides
    fun privilegeStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.PrivilegeApi {
        return retrofit.create(OpenPressingStrapiApi.PrivilegeApi::class.java)
    }

    @Provides
    fun promotionStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.PromotionApi {
        return retrofit.create(OpenPressingStrapiApi.PromotionApi::class.java)
    }

    @Provides
    fun quarterStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.QuarterApi {
        return retrofit.create(OpenPressingStrapiApi.QuarterApi::class.java)
    }

    @Provides
    fun requirementStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.RequirementApi {
        return retrofit.create(OpenPressingStrapiApi.RequirementApi::class.java)
    }

    @Provides
    fun requirementDetailStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.RequirementDetailsApi {
        return retrofit.create(OpenPressingStrapiApi.RequirementDetailsApi::class.java)
    }

    @Provides
    fun serviceStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.ServiceApi {
        return retrofit.create(OpenPressingStrapiApi.ServiceApi::class.java)
    }

    @Provides
    fun serviceCategoryStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.ServiceCategoryApi {
        return retrofit.create(OpenPressingStrapiApi.ServiceCategoryApi::class.java)
    }

    @Provides
    fun serviceTypeStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.ServiceTypeApi {
        return retrofit.create(OpenPressingStrapiApi.ServiceTypeApi::class.java)
    }

    @Provides
    fun userStrapiApi(retrofit: Retrofit): OpenPressingStrapiApi.UserApi {
        return  retrofit.create(OpenPressingStrapiApi.UserApi::class.java)
    }

}