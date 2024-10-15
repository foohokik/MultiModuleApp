package com.example.core.data.model

import java.io.Serializable

data class VacancyResponse(
    val addressResponse: AddressResponse,
    val appliedNumber: Int = 0,
    val company: String?,
    val description: String?,
    val experience: ExperienceResponse,
    val id: String?,
    val isFavorite: Boolean = false,
    val lookingNumber: Int = 0,
    val publishedDate: String?,
    val questions: List<String>?,
    val responsibilities: String?,
    val salary: SalaryResponse,
    val schedules: List<String> = emptyList(),
    val title: String?
) : Serializable