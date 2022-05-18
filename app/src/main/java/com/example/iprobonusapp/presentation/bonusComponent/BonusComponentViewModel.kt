package com.example.iprobonusapp.presentation.bonusComponent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apibonus.RetrofitService
import com.example.iprobonusapp.data.converter.toDomainModel
import com.example.iprobonusapp.data.model.BonusData
import com.example.iprobonusapp.extensions.SingleLiveEvent
import com.example.iprobonusapp.ui.bonusComponent.BonusComponentFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BonusComponentViewModel : ViewModel() {
    private val apiService = RetrofitService()
    private var _bonusData: MutableLiveData<BonusData> = SingleLiveEvent()
    var bonusData: LiveData<BonusData> = _bonusData

    fun getBonusData() {
        CoroutineScope(Dispatchers.IO).launch {
            val accessTokenString = apiService.getAccessToken(
                BonusComponentFragment.clientID,
                BonusComponentFragment.deviceID
            )
            _bonusData.postValue(apiService.getBonusData(accessTokenString)?.toDomainModel())
        }
    }

    fun initRetrofit() {
        apiService.initRetrofit()
    }

}