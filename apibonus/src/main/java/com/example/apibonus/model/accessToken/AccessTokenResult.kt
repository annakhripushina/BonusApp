package com.example.apibonus.model.accessToken

data class AccessTokenResult(
    val status: Int,
    val message: String?,
    val messageDev: String?,
    val codeResult: Int,
    val duration: Double,
    val idLog: String
)