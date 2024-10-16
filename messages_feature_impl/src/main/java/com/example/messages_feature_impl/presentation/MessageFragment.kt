package com.example.messages_feature_impl.presentation

import com.example.core_utils.presentation.BaseFragmentBinding
import com.example.messages_feature_impl.databinding.FragmentMessageBinding
import com.example.messages_feature_impl.di.MessagesFeatureComponentHolder

class MessageFragment :
    BaseFragmentBinding<FragmentMessageBinding>(FragmentMessageBinding::inflate) {

    init {
        MessagesFeatureComponentHolder.getComponent().inject(this)
    }
}