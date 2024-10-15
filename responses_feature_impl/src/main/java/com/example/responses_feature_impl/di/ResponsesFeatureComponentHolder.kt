package com.example.responses_feature_impl.di

import com.example.module_injector.ComponentHolder
import com.example.responses_feature_api.ResponsesFeatureApi

object ResponsesFeatureComponentHolder : ComponentHolder<ResponsesFeatureApi, ResponsesFeatureDependencies> {
    private var responsesComponent: ResponsesFeatureComponent? = null
    override fun init(dependencies: ResponsesFeatureDependencies) {
        if (responsesComponent == null) {
            synchronized(this) {
                if (responsesComponent == null) {
                    responsesComponent = ResponsesFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): ResponsesFeatureApi = getComponent()

    internal fun getComponent(): ResponsesFeatureComponent {
        checkNotNull(responsesComponent) { "ResponsesFeatureComponent was not initialized!" }
        return responsesComponent!!
    }

    override fun reset() {
        responsesComponent = null
    }
}