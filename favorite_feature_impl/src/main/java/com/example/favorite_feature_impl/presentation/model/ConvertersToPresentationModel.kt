package com.example.favorite_feature_impl.presentation.model
import com.example.core_utils.presentation.model.AddressUI
import com.example.core_utils.presentation.model.ExperienceUI
import com.example.core_utils.presentation.model.SalaryUI
import com.example.favorite_feature_impl.domain.model.Address
import com.example.favorite_feature_impl.domain.model.Experience
import com.example.favorite_feature_impl.domain.model.Salary
import com.example.favorite_feature_impl.domain.model.Vacancy



fun Address.toAddressUI(): AddressUI = AddressUI(house,street, town)

fun AddressUI.toAddress(): Address = Address(house,street, town)


fun Experience.toExperienceUI(): ExperienceUI = ExperienceUI(previewText, text)


fun ExperienceUI.toExperience(): Experience = Experience(previewText, text)

fun Salary.toSalaryUI (): SalaryUI = SalaryUI(full, short)

fun SalaryUI.toSalary (): Salary = Salary(full, short)

fun Vacancy.toVacancyUI(): VacancyUI {
    return VacancyUI(
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

fun List<Vacancy>.toVacanciesListUI():List<VacancyUI> = this.map {it.toVacancyUI()}

