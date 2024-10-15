package com.example.favorite_feature_impl.presentation.model

import com.example.core_utils.presentation.model.AddressUI
import com.example.core_utils.presentation.model.ExperienceUI
import com.example.core_utils.presentation.model.SalaryUI

data class VacancyUI(
    val address: AddressUI,
    val company: String,
    val experience: ExperienceUI,
    val id: String,
    var isFavorite: Boolean,
    val lookingNumber: Int,
    val publishedDate: String,
    val salary: SalaryUI,
    val title: String
)
