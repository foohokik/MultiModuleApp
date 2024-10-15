package com.example.favorite_feature_impl.presentation

import com.example.favorite_feature_impl.presentation.model.VacancyUI


sealed class SideEffects  {
    data class ErrorEffect(val err: String): SideEffects()
    data class ExceptionEffect(val throwable: Throwable): SideEffects()
    data class ClickEffectNavigation(val item: VacancyUI): SideEffects()
}
