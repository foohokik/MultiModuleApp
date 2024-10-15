package com.example.full_vacancy_feature_impl.presentation.model

import com.example.core_utils.presentation.model.AddressUI
import com.example.core_utils.presentation.model.ExperienceUI
import com.example.core_utils.presentation.model.SalaryUI
import com.example.full_vacancy_feature_impl.domain.model.Address
import com.example.full_vacancy_feature_impl.domain.model.Experience
import com.example.full_vacancy_feature_impl.domain.model.Salary
import com.example.full_vacancy_feature_impl.domain.model.Vacancy


fun Address.toAddressUI(): AddressUI = AddressUI(house, street, town)

fun AddressUI.toAddress(): Address = Address(house, street, town)


fun Experience.toExperienceUI(): ExperienceUI = ExperienceUI(previewText, text)


fun ExperienceUI.toExperience(): Experience = Experience(previewText, text)

fun Salary.toSalaryUI(): SalaryUI = SalaryUI(full, short)

fun SalaryUI.toSalary(): Salary = Salary(full, short)


fun Vacancy.toVacancyUI(): VacancyUI {
    return VacancyUI(
        address.toAddressUI(),
        appliedNumber,
        company,
        description,
        experience.toExperienceUI(),
        id,
        isFavorite,
        lookingNumber,
        publishedDate,
        questions,
        responsibilities,
        salary.toSalaryUI(),
        schedules,
        title
    )
}

fun VacancyUI.toVacancy(): Vacancy = Vacancy(
    address.toAddress(),
    appliedNumber,
    company,
    description,
    experience.toExperience(),
    id,
    isFavorite,
    lookingNumber,
    publishedDate,
    questions,
    responsibilities,
    salary.toSalary(),
    schedules,
    title
)
