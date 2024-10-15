package com.example.favorite_feature_impl.di

import com.example.core_utils.di.Feature
import com.example.favorite_feature_api.FavoriteApi
import com.example.favorite_feature_impl.presentation.FavoriteFragment
import com.example.favorite_feature_impl.presentation.FavoriteViewModel
import dagger.Component

@Component(
    modules = [FavoriteFeatureModule::class, DispatcherModule::class],
    dependencies = [FavoriteFeatureDependencies::class]
)

@Feature
interface FavoriteFeatureComponent : FavoriteApi {

    fun inject(favoriteFragment: FavoriteFragment)

    fun getFavoriteViewModelFactory(): FavoriteViewModel.Factory

    companion object {
        fun initAndGet(favoriteFeatureDependencies: FavoriteFeatureDependencies): FavoriteFeatureComponent {
            return DaggerFavoriteFeatureComponent.builder()
                .favoriteFeatureDependencies(favoriteFeatureDependencies)
                .build()
        }
    }
}