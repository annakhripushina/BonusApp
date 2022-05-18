package com.example.apibonus

import com.example.apibonus.model.accessToken.AccessTokenRequest
import com.example.apibonus.model.bonusController.BonusControllerData
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object {
        var BASE_URL = "https://mp1.iprobonus.com/"
    }

    private lateinit var service: ApiService

    fun initRetrofit() {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                return@addInterceptor chain.proceed(
                    chain
                        .request()
                        .newBuilder()
                        .addHeader(
                            "AccessKey",
                            "891cf53c-01fc-4d74-a14c-592668b7a03c"
                        )
                        .build()
                )
            }
            .build()

        service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(ApiService::class.java)

    }

    suspend fun getAccessToken(clientID: String, deviceID: String): String? {
        return service.getAccessToken(
            AccessTokenRequest(
                idClient = clientID,
                paramValue = deviceID
            )
        ).accessToken
    }

    suspend fun getBonusData(accessToken: String?): BonusControllerData? {
        return accessToken?.let { service.getBonus(it).data }
    }
}