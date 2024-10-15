package com.example.full_vacancy_feature_impl.domain

import com.example.full_vacancy_feature_impl.domain.repo.LocalVacancyRepo
import com.example.full_vacancy_feature_impl.presentation.model.VacancyUI
import com.example.full_vacancy_feature_impl.presentation.model.toVacancyUI
import javax.inject.Inject

class FullVacancyFeatureInteractor @Inject constructor(
    private val localVacancyRepo: LocalVacancyRepo
) {

    suspend fun getVacancyById(id: String): VacancyUI {
        return localVacancyRepo.getVacancyById(id).toVacancyUI()
    }

    suspend fun updateVacancyIsFavorite(isFavorite: Boolean, id: String) {
        localVacancyRepo.updateVacancyIsFavorite(isFavorite, id)
    }


}