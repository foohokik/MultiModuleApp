package com.example.full_vacancy_feature_impl.data

import com.example.core_database.domain.VacancyDao
import com.example.full_vacancy_feature_impl.domain.model.Vacancy
import com.example.full_vacancy_feature_impl.domain.model.toVacancy
import com.example.full_vacancy_feature_impl.domain.model.toVacancyEntity
import com.example.full_vacancy_feature_impl.domain.repo.LocalVacancyRepo
import javax.inject.Inject

class LocalVacancyRepoImpl@Inject constructor(private val dao: VacancyDao) : LocalVacancyRepo {

    override suspend fun saveVacancy(item: Vacancy) = dao.insertVacancy(item.toVacancyEntity())

    override suspend fun getVacancyById(id: String): Vacancy = dao.getVacancyById(id).toVacancy()

    override suspend fun deleteVacancyById(id: String) = dao.deleteVacancy(id)

    override suspend fun updateVacancyIsFavorite(isFavorite: Boolean, id: String) = dao.updateVacancyIsFavorite(isFavorite,id)
}