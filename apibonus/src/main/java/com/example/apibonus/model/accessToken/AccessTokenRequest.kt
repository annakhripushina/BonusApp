package com.example.apibonus.model.accessToken

data class AccessTokenRequest(
    val idClient: String? = "2c44d8c2-c89a-472e-aab3-9a8a29142315",
    val accessToken: String? = "",
    val paramName: String? = "device",
    val paramValue: String? = "7db72635-fd0a-46b9-813b-1627e3aa02ea",
    val latitude: Float = 0f,
    val longitude: Float = 0f,
    val sourceQuery: Int = 0
)