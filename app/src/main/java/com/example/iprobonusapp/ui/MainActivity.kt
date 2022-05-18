package com.example.iprobonusapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.iprobonusapp.R
import com.example.iprobonusapp.ui.bonusComponent.BonusComponentFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bonus_fragment)

        supportFragmentManager.beginTransaction()
            .replace(R.id.bonus_card, BonusComponentFragment())
            .addToBackStack("BonusComponent")
            .commit()

    }


}