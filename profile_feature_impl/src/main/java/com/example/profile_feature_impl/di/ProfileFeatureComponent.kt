package com.example.profile_feature_impl.di

import com.example.core_utils.di.Feature
import com.example.profile_feature_api.ProfileFeatureApi
import com.example.profile_feature_impl.presentation.ProfileFragment
import dagger.Component

@Component(
    dependencies = [ProfileFeatureDependencies::class]
)
@Feature
interface ProfileFeatureComponent : ProfileFeatureApi {

    fun inject(profileFragment: ProfileFragment)

    companion object {
        fun initAndGet(profileFeatureDependencies: ProfileFeatureDependencies): ProfileFeatureComponent {
            return DaggerProfileFeatureComponent.builder()
                .profileFeatureDependencies(profileFeatureDependencies)
                .build()
        }
    }
}