package com.example.apibonus.model.bonusController

data class BonusControllerResult(
    val status: Int,
    val message: String?,
    val messageDev: String?,
    val codeResult: Int,
    val duration: Double,
    val idLog: String
)
