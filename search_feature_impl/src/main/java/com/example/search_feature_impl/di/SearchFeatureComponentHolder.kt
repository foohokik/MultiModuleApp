package com.example.search_feature_impl.di

import com.example.module_injector.ComponentHolder
import com.example.search_feature_api.SearchFeatureApi

object SearchFeatureComponentHolder : ComponentHolder<SearchFeatureApi, SearchFeatureDependencies> {
    private var searchComponent: SearchFeatureComponent? = null
    override fun init(dependencies: SearchFeatureDependencies) {
        if (searchComponent == null) {
            synchronized(this) {
                if (searchComponent == null) {
                    searchComponent = SearchFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): SearchFeatureApi = getComponent()

    internal fun getComponent(): SearchFeatureComponent {
        checkNotNull(searchComponent) { "SearchFeatureComponent was not initialized!" }
        return searchComponent!!
    }

    override fun reset() {
        searchComponent = null
    }
}