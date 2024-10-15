package com.example.search_feature_impl.presentation.model

import com.example.core_utils.presentation.model.AddressUI
import com.example.core_utils.presentation.model.ExperienceUI
import com.example.core_utils.presentation.model.SalaryUI
import com.example.search_feature_impl.domain.model.Address
import com.example.search_feature_impl.domain.model.Experience
import com.example.search_feature_impl.domain.model.Offer
import com.example.search_feature_impl.domain.model.Offers
import com.example.search_feature_impl.domain.model.Salary
import com.example.search_feature_impl.domain.model.Vacancy

fun Offer.toOfferUI(): OfferUI = OfferUI(
    button,
    id,
    link,
    icon = chooseIcon(id),
    title = title
)


fun chooseIcon(id: String?): Int {
    return when (id) {
        "near_vacancies" -> com.example.core_utils.R.drawable.ic_person_blue
        "level_up_resume" -> com.example.core_utils.R.drawable.ic_star
        "temporary_job" -> com.example.core_utils.R.drawable.ic_list
        else -> 0
    }
}

fun List<Offer>.toOffersListUI(): List<OfferUI> = this.map { it.toOfferUI() }

fun Address.toAddressUI(): AddressUI = AddressUI(house, street, town)

fun AddressUI.toAddress(): Address = Address(house, street, town)


fun Experience.toExperienceUI(): ExperienceUI = ExperienceUI(previewText, text)


fun ExperienceUI.toExperience(): Experience = Experience(previewText, text)

fun Salary.toSalaryUI(): SalaryUI = SalaryUI(full, short)

fun SalaryUI.toSalary(): Salary = Salary(full, short)


fun Vacancy.toVacancyUI(): OffersUI.VacancyUI {
    return OffersUI.VacancyUI(
        address.toAddressUI(),
        company,
        experience.toExperienceUI(),
        id,
        isFavorite,
        lookingNumber,
        publishedDate,
        salary.toSalaryUI(),
        title
    )
}

fun List<Vacancy>.toVacanciesListUI(): List<OffersUI.VacancyUI> = this.map { it.toVacancyUI() }


fun Offers.toCommonList(): OffersUI.CommonList = OffersUI.CommonList(
    offers?.toOffersListUI()
)

