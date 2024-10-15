package com.example.search_feature_impl.domain.model


data class Offers(
    val offers: List<Offer>? = emptyList(),
    val vacancies: List<Vacancy>? = emptyList()
)