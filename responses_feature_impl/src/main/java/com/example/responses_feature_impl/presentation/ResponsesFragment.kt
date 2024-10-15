package com.example.responses_feature_impl.presentation

import com.example.core_utils.presentation.BaseFragmentBinding
import com.example.responses_feature_impl.databinding.FragmentResponsesBinding
import com.example.responses_feature_impl.di.ResponsesFeatureComponentHolder

class ResponsesFragment :
    BaseFragmentBinding<FragmentResponsesBinding>(FragmentResponsesBinding::inflate){

    init {
        ResponsesFeatureComponentHolder.getComponent().inject(this)
    }

}