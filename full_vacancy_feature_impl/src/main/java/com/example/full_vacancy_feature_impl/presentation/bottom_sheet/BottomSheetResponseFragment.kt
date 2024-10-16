package com.example.full_vacancy_feature_impl.presentation.bottom_sheet

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.example.core_utils.presentation.BaseDialogBinding
import com.example.full_vacancy_feature_impl.databinding.BottomSheetResponseBinding

class BottomSheetResponseFragment :
    BaseDialogBinding<BottomSheetResponseBinding>(BottomSheetResponseBinding::inflate) {

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