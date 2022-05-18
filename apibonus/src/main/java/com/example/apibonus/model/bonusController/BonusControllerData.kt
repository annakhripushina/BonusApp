package com.example.apibonus.model.bonusController

data class BonusControllerData(
    val typeBonusName: String?,
    var currentQuantity: Double,
    val forBurningQuantity: Double,
    val dateBurning: String
)
