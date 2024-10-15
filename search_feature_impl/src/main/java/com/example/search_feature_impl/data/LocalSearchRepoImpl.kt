package com.example.search_feature_impl.data

import com.example.core_database.domain.VacancyDao
import com.example.search_feature_impl.domain.model.Offer
import com.example.search_feature_impl.domain.model.Vacancy
import com.example.search_feature_impl.domain.model.toOffers
import com.example.search_feature_impl.domain.model.toOffersEntity
import com.example.search_feature_impl.domain.model.toVacancies
import com.example.search_feature_impl.domain.model.toVacanciesEntity
import com.example.search_feature_impl.domain.model.toVacancy
import com.example.search_feature_impl.domain.model.toVacancyEntity
import com.example.search_feature_impl.domain.repo.LocalSearchRepo
import javax.inject.Inject

class LocalSearchRepoImpl @Inject constructor(private val dao: VacancyDao) : LocalSearchRepo

{
    override suspend fun getAllVacancies(): List<Vacancy> = dao.getAllVacancies().toVacancies()

    override suspend fun saveVacancies(items: List<Vacancy>?) {
        items?.let { dao.insertVacancies(it.toVacanciesEntity()) }
    }

    override suspend fun updateVacancyIsFavorite(isFavorite: Boolean, id: String) = dao.updateVacancyIsFavorite(isFavorite,id)
    override suspend fun getAllOffers(): List<Offer> = dao.getAllOffers().toOffers()
    override suspend fun saveOffers(items: List<Offer>?) {
        items?.let { dao.insertOffers(it.toOffersEntity()) }
        }

}