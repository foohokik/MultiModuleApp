package com.example.auth_feature_impl.presentation.pin

import androidx.lifecycle.ViewModel
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

private const val LENGTH = 4

class PinViewModel @AssistedInject constructor(): ViewModel() {

    private val _isButtonEnabled = MutableStateFlow(false)
    val isButtonEnabled = _isButtonEnabled.asStateFlow()


    fun checkPin(pin: String) {
        _isButtonEnabled.value = pin.length == LENGTH
    }


    @AssistedFactory
    interface Factory {
        fun create(): PinViewModel
    }

}