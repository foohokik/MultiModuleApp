package com.example.search_feature_impl.di

import com.example.core_utils.di.Feature
import com.example.search_feature_api.SearchFeatureApi
import com.example.search_feature_impl.presentation.SearchFragment
import com.example.search_feature_impl.presentation.SearchViewModel
import dagger.Component

@Component(
    modules = [SearchFeatureModule::class, DispatcherModule::class, FlowModule::class],
    dependencies = [SearchFeatureDependencies::class]
)
@Feature
interface SearchFeatureComponent : SearchFeatureApi {

    fun inject(searchFragment: SearchFragment)
    fun getSearchViewModelFactory(): SearchViewModel.Factory

    companion object {
        fun initAndGet(searchFeatureDependencies: SearchFeatureDependencies): SearchFeatureComponent {
            return DaggerSearchFeatureComponent.builder()
                .searchFeatureDependencies(searchFeatureDependencies)
                .build()
        }
    }
}