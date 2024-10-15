package com.example.auth_feature_impl.presentation



sealed class SideEffects  {
    data class ErrorEffect(val err: String): SideEffects()
    data class ExceptionEffect(val throwable: Throwable): SideEffects()
    data class ClickEffectNavigation(val email: String): SideEffects()
}
