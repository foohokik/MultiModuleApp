package com.example.favorite_feature_impl.di

import com.example.core_utils.di.Feature
import com.example.favorite_feature_impl.data.LocalFavoriteRepoImpl
import com.example.favorite_feature_impl.domain.repo.LocalFavoriteRepo
import dagger.Binds
import dagger.Module

@Module
interface FavoriteFeatureModule {

    @Feature
    @Binds
    fun bindLocalRepository(repo: LocalFavoriteRepoImpl): LocalFavoriteRepo
}