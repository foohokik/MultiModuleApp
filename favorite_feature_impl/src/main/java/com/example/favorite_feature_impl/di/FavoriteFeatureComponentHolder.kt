package com.example.favorite_feature_impl.di

import com.example.favorite_feature_api.FavoriteApi
import com.example.module_injector.ComponentHolder

object FavoriteFeatureComponentHolder : ComponentHolder<FavoriteApi, FavoriteFeatureDependencies> {

    private var favoriteFeatureComponent: FavoriteFeatureComponent? = null

    override fun init(dependencies: FavoriteFeatureDependencies) {
        if (favoriteFeatureComponent == null) {
            synchronized(this) {
                if (favoriteFeatureComponent == null) {
                    favoriteFeatureComponent = FavoriteFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): FavoriteApi = getComponent()

    internal fun getComponent(): FavoriteFeatureComponent {
        checkNotNull(favoriteFeatureComponent) { "FavoriteFeatureComponent was not initialized!" }
        return favoriteFeatureComponent!!
    }

    override fun reset() {
        favoriteFeatureComponent = null
    }

}