package com.example.auth_feature_impl.presentation.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth_feature_impl.presentation.SideEffects
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel @AssistedInject constructor(

): ViewModel() {

    private val _loginFlowState = MutableStateFlow(LoginScreenState())
    val searchFlowState = _loginFlowState.asStateFlow()

    private val _sideEffects = Channel<SideEffects>()
    val sideEffects = _sideEffects.receiveAsFlow()


    fun clearFlowAndOnChangeKeyBoardFlag() {
        _loginFlowState.update { state ->
            state.copy(
                email = "", keyboardState = false)
        }
    }

    fun checkEmailAndNavigate () {
        val email = _loginFlowState.value.email
        viewModelScope.launch {
            if (!email.matches(Patterns.EMAIL_ADDRESS.toRegex())) {
                _sideEffects.send(SideEffects.ErrorEffect("Вы ввели неверный e-mail"))
            } else {
                _sideEffects.send(SideEffects.ClickEffectNavigation(email))
            }
        }
    }

    fun listenEmail(email: String) {
        _loginFlowState.update {state ->
            state.copy(email = email)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(): LoginViewModel
    }


}