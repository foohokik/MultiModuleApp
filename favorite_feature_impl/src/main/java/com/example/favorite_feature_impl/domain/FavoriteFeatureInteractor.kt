package com.example.favorite_feature_impl.domain

import com.example.favorite_feature_impl.domain.repo.LocalFavoriteRepo
import javax.inject.Inject

class FavoriteFeatureInteractor @Inject constructor(
    private val localFavoriteRepo: LocalFavoriteRepo,
)
{
    suspend fun getAllVacancies () = localFavoriteRepo.getAllFavoriteVacancies()


    suspend fun updateVacancyIsFavorite (isFavorite: Boolean, id: String) = localFavoriteRepo.updateVacancyIsFavorite(isFavorite, id)


}