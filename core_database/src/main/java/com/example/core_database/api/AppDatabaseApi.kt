package com.example.core_database.api

import com.example.core_database.domain.VacancyDao
import com.example.module_injector.BaseAPI

interface AppDatabaseApi: BaseAPI {
    fun getVacancyDao() : VacancyDao
}