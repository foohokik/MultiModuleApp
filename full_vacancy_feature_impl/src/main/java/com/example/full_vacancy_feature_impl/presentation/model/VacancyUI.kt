package com.example.full_vacancy_feature_impl.presentation.model

import com.example.core_utils.presentation.model.AddressUI
import com.example.core_utils.presentation.model.ExperienceUI
import com.example.core_utils.presentation.model.SalaryUI

data class VacancyUI(
    val address: AddressUI = AddressUI(house = "", street = "", town = ""),
    val appliedNumber: Int = 0,
    val company: String = "",
    val description: String = "",
    val experience: ExperienceUI = ExperienceUI("", ""),
    val id: String ="",
    var isFavorite: Boolean = false,
    val lookingNumber: Int = 0,
    val publishedDate: String = "",
    val questions: List<String> = emptyList(),
    val responsibilities: String = "",
    val salary: SalaryUI = SalaryUI("", ""),
    val schedules: String = "",
    val title: String = ""
)
