package com.example.favorite_feature_impl.di

import com.example.core_database.domain.VacancyDao
import com.example.module_injector.BaseDependencies

interface FavoriteFeatureDependencies : BaseDependencies {

    fun getVacanciesDao(): VacancyDao
}