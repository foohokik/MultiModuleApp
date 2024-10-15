package com.example.full_vacancy_feature_impl.domain.repo

import com.example.full_vacancy_feature_impl.domain.model.Vacancy


interface LocalVacancyRepo {

    suspend fun saveVacancy (item: Vacancy)

    suspend fun getVacancyById (id: String) : Vacancy

    suspend fun deleteVacancyById (id: String)

    suspend fun updateVacancyIsFavorite (isFavorite: Boolean, id: String)

}