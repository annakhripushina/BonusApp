package com.example.iprobonusapp.data.converter

import com.example.apibonus.model.bonusController.BonusControllerData
import com.example.iprobonusapp.data.model.BonusData

internal fun BonusControllerData.toDomainModel() = BonusData(
    currentQuantity,
    forBurningQuantity,
    dateBurning
)