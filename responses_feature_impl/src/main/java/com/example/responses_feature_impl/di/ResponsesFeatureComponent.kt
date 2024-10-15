package com.example.responses_feature_impl.di

import com.example.core_utils.di.Feature
import com.example.responses_feature_api.ResponsesFeatureApi
import com.example.responses_feature_impl.presentation.ResponsesFragment
import dagger.Component

@Component(
    dependencies = [ResponsesFeatureDependencies::class]
)
@Feature
interface ResponsesFeatureComponent : ResponsesFeatureApi {

    fun inject(responsesFragment: ResponsesFragment)

    companion object {
        fun initAndGet(responsesFeatureDependencies: ResponsesFeatureDependencies): ResponsesFeatureComponent {
            return DaggerResponsesFeatureComponent.builder()
                .responsesFeatureDependencies(responsesFeatureDependencies)
                .build()
        }
    }
}