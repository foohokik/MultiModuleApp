package com.example.full_vacancy_feature_impl.presentation.adapter

import com.example.full_vacancy_feature_impl.databinding.ItemQuestionBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun questionAdapterDelegate() = adapterDelegateViewBinding<String, String, ItemQuestionBinding>({ layoutInflater, root ->
    ItemQuestionBinding.inflate(layoutInflater, root, false)
}) {

    bind {
        binding.text.text = item
    }
}