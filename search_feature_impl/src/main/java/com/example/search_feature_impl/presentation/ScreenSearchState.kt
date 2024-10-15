package com.example.search_feature_impl.presentation

import com.example.search_feature_impl.presentation.model.OffersUI

data class ScreenSearchState (
    val errorMessage: String = "",
    val offers: List<OffersUI> = emptyList(),
    val isFullVacanciesList : Boolean = false,
    val numberOfVacancies : Int? = null
)
