package com.example.iprobonusapp.ui.bonusComponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.bonuscomponent.BonusComponent
import com.example.iprobonusapp.R
import com.example.iprobonusapp.presentation.bonusComponent.BonusComponentViewModel
import com.example.bonuscomponent.databinding.BonusCardBinding


class BonusComponentFragment : Fragment() {
    companion object {
        const val clientID = "2c44d8c2-c89a-472e-aab3-9a8a29142315"
        const val deviceID = "7db72635-fd0a-46b9-813b-1627e3aa02ea"
        const val customColorBackground = R.color.white
    }

    private lateinit var binding: BonusCardBinding
    private val viewModel: BonusComponentViewModel by viewModels()
    private val bonusView = BonusComponent()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BonusCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeSizeComponents()
        changeColorComponents()

        viewModel.initRetrofit()
        viewModel.getBonusData()

        viewModel.bonusData.observe(viewLifecycleOwner, Observer { it ->
            if (viewModel.bonusData.value != null)
                activity?.application?.let { app ->
                    bonusView.setBonusData(
                        app,
                        binding,
                        it.currentQuantity,
                        it.dateBurning,
                        it.forBurningQuantity
                    )
                }
        })
    }

    private fun changeSizeComponents() {
        binding.currentQuantity.setTextAppearance(R.style.textCurrentQuantityApp)
        binding.dateBurning.setTextAppearance(R.style.textBurningApp)
        binding.dateBurning.setTextAppearance(R.style.textBurningApp)
    }

    private fun changeColorComponents() {
        binding.root.backgroundTintList = requireActivity().resources.getColorStateList(
            customColorBackground, null
        )
    }

}