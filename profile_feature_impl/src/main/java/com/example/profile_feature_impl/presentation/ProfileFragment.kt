package com.example.profile_feature_impl.presentation

import com.example.core_utils.presentation.BaseFragmentBinding
import com.example.profile_feature_impl.databinding.FragmenProfileBinding
import com.example.profile_feature_impl.di.ProfileFeatureComponentHolder

class ProfileFragment :
    BaseFragmentBinding<FragmenProfileBinding>(FragmenProfileBinding::inflate){

    init {
        ProfileFeatureComponentHolder.getComponent().inject(this)
    }

}