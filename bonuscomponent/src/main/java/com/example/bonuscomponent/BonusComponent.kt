package com.example.bonuscomponent

import android.app.Application
import com.example.bonuscomponent.databinding.BonusCardBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BonusComponent {
    fun setBonusData(
        application: Application,
        binding: BonusCardBinding,
        currentQuantity: Double,
        dateBurning: String,
        forBurningQuantity: Double
    ) {
        binding.currentQuantity.text = quantityFormat(
            application,
            currentQuantity
        )
        binding.dateBurning.text =
            LocalDateTime.parse(dateBurning).format(DateTimeFormatter.ofPattern("dd.MM сгорит"))

        binding.forBurningQuantity.text = quantityFormat(
            application,
            forBurningQuantity
        )
    }

    private fun quantityFormat(application: Application, quantity: Double): String {
        val quantityString: String =
            if ((quantity.rem(1.0)) != 0.0) {
                String.format("%s", quantity) + " " + application.resources.getQuantityString(
                    R.plurals.pluralsBonus,
                    quantity.toInt()
                )
            } else {
                String.format("%.0f", quantity) + " " + application.resources.getQuantityString(
                    R.plurals.pluralsBonus,
                    quantity.toInt()
                )
            }
        return quantityString
    }

}