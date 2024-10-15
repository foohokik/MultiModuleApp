package com.example.full_vacancy_feature_impl.di

import com.example.core_utils.di.Feature
import com.example.full_vacancy_feature_impl.data.LocalVacancyRepoImpl
import com.example.full_vacancy_feature_impl.domain.repo.LocalVacancyRepo
import dagger.Binds
import dagger.Module

@Module
interface FullVacancyFeatureModule {

    @Feature
    @Binds
    fun bindLocalRepository(repo: LocalVacancyRepoImpl): LocalVacancyRepo
}