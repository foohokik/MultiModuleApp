package com.example.full_vacancy_feature_impl.presentation.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.example.core_utils.presentation.BaseFragmentBinding
import com.example.full_vacancy_feature_impl.R
import com.example.full_vacancy_feature_impl.databinding.BottomSheetResponseBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetResponseFragment :
    BaseFragmentBinding<BottomSheetResponseBinding>(BottomSheetResponseBinding::inflate) {

    private val args by navArgs<BottomSheetResponseFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        with(binding) {
            tvJobTitle.text = args.title
            tvAddLetter.setOnClickListener {
                tvAddLetter.isVisible = false
                editTvLetter.isVisible = true
            }
        }
    }

}