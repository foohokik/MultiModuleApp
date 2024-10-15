package com.example.favorite_feature_impl.data

import com.example.core_database.domain.VacancyDao
import com.example.favorite_feature_impl.domain.model.toVacancies
import com.example.favorite_feature_impl.domain.repo.LocalFavoriteRepo
import javax.inject.Inject

class LocalFavoriteRepoImpl @Inject constructor(private val dao: VacancyDao) : LocalFavoriteRepo {

    override suspend fun getAllFavoriteVacancies() = dao.getAllFavoriteVacancies().toVacancies()

    override suspend fun updateVacancyIsFavorite(isFavorite: Boolean, id: String) =
        dao.updateVacancyIsFavorite(isFavorite, id)

}