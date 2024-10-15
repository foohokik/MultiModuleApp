package com.example.search_feature_impl.di

import com.example.core_database.domain.VacancyDao
import com.example.core_network.impl.JobApi
import com.example.core_network.impl.response.HttpResultToDataWrapperConverter
import com.example.module_injector.BaseDependencies

interface SearchFeatureDependencies : BaseDependencies {
    fun getVacanciesDao(): VacancyDao
    fun getJobApi(): JobApi

    fun getConvertor(): HttpResultToDataWrapperConverter
}