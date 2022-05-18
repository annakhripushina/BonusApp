package com.example.apibonus

import com.example.apibonus.model.accessToken.AccessTokenRequest
import com.example.apibonus.model.accessToken.AccessTokenResponse
import com.example.apibonus.model.bonusController.BonusControllerResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("/api/v3/ibonus/generalinfo/{AccessToken}")
    suspend fun getBonus(
        @Path("AccessToken") accessToken: String
    ): BonusControllerResponse

    @POST("/api/v3/clients/accesstoken")
    suspend fun getAccessToken(@Body accessTokenRequest: AccessTokenRequest): AccessTokenResponse
}