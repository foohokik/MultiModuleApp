package com.example.search_feature_impl.presentation

import com.example.search_feature_impl.presentation.model.OffersUI


sealed class SideEffects  {
    data class ErrorEffect(val err: String): SideEffects()
    data class ExceptionEffect(val throwable: Throwable): SideEffects()
    data class ClickEffectNavigation(val item: OffersUI.VacancyUI): SideEffects()
}
