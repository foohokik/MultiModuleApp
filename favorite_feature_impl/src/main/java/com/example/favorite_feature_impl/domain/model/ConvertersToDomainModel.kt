package com.example.favorite_feature_impl.domain.model

import com.example.core.data.model.AddressResponse
import com.example.core.data.model.ExperienceResponse
import com.example.core.data.model.SalaryResponse
import com.example.core.data.model.VacancyResponse
import com.example.core_database.impl.data.VacancyEntity


fun AddressResponse?.toAddress(): Address =
    Address(this?.house ?: "", this?.street ?: "", this?.town ?: "")

fun Address.toAddress(): AddressResponse = AddressResponse(house, street, town)

fun ExperienceResponse.toExperience(): Experience =
    Experience(previewText.orEmpty(), text.orEmpty())


fun Experience.toExperience(): ExperienceResponse = ExperienceResponse(previewText, text)

fun SalaryResponse.toSalary(): Salary = Salary(full.orEmpty(), short.orEmpty())

fun Salary.toSalary(): SalaryResponse = SalaryResponse(full, short)


fun VacancyResponse.toVacancy(): Vacancy {
    return Vacancy(
        addressResponse.toAddress(),
        appliedNumber,
        company.orEmpty(),
        description.orEmpty(),
        experience.toExperience(),
        id.orEmpty(),
        isFavorite,
        lookingNumber,
        publishedDate.orEmpty(),
        questions.orEmpty(),
        responsibilities.orEmpty(),
        salary.toSalary(),
        schedules.toStringComma(),
        title.orEmpty()
    )
}

fun List<String>.toStringComma(): String {
    val str = this.joinToString(
        separator = ", ",
        prefix = "",
        postfix = "",
    )
    return str.replaceFirstChar { it.uppercase() }
}

fun List<VacancyResponse>.toVacanciesListUI(): List<Vacancy> = this.map { it.toVacancy() }


fun VacancyEntity.toVacancy(): Vacancy {
    return Vacancy(
        addressResponse.toAddress(),
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
}

fun List<VacancyEntity>.toVacancies(): List<Vacancy> = this.map { it.toVacancy() }

fun Vacancy.toVacancyEntity(): VacancyEntity {
    return VacancyEntity(
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
}

fun List<Vacancy>.toVacanciesEntity(): List<VacancyEntity> = this.map { it.toVacancyEntity() }

