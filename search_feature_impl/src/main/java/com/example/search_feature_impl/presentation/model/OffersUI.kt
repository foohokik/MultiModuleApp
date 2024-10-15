package com.example.search_feature_impl.presentation.model

import com.example.core_utils.presentation.model.AddressUI
import com.example.core_utils.presentation.model.ExperienceUI
import com.example.core_utils.presentation.model.SalaryUI
import java.io.Serializable

sealed class OffersUI {

    data class VacancyUI(
        val address: AddressUI,
        val company: String,
        val experience: ExperienceUI,
        val id: String,
        val isFavorite: Boolean,
        val lookingNumber: Int,
        val publishedDate: String,
        val salary: SalaryUI,
        val title: String
    ) : Serializable, OffersUI()

    data class Header(
        val header: String = "Вакансии для Вас"
    ) :OffersUI()

    data class CommonList(
        val offers: List<OfferUI>?
    ) : OffersUI()

    data class QuantityOfVacanciesButton(
        val qty: Int
    ) : OffersUI()

}