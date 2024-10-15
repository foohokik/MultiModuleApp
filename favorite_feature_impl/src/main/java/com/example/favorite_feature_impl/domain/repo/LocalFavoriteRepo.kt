package com.example.favorite_feature_impl.domain.repo

import com.example.favorite_feature_impl.domain.model.Vacancy

interface LocalFavoriteRepo {

    suspend fun getAllFavoriteVacancies(): List<Vacancy>

    suspend fun updateVacancyIsFavorite (isFavorite: Boolean, id: String)
}