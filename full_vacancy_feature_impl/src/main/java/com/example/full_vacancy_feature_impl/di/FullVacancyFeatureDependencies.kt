package com.example.full_vacancy_feature_impl.di

import com.example.core_database.domain.VacancyDao
import com.example.module_injector.BaseDependencies

interface FullVacancyFeatureDependencies : BaseDependencies {

    fun getVacanciesDao(): VacancyDao

}