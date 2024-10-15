package com.example.auth_feature_impl.di

import com.example.auth_feature_api.AuthFeatureApi
import com.example.auth_feature_impl.presentation.login.LoginFragment
import com.example.auth_feature_impl.presentation.login.LoginViewModel
import com.example.auth_feature_impl.presentation.pin.PinFragment
import com.example.auth_feature_impl.presentation.pin.PinViewModel
import dagger.Component

@Component(
    dependencies = [AuthFeatureDependencies::class]
)
interface AuthFeatureComponent: AuthFeatureApi {

    fun inject(loginFragment: LoginFragment)

    fun inject(pinFragment: PinFragment)

    fun getLoginViewModelFactory(): LoginViewModel.Factory

    fun getPinViewModelFactory(): PinViewModel.Factory

    companion object {
        fun initAndGet(authFeatureDependencies: AuthFeatureDependencies): AuthFeatureComponent {
            return DaggerAuthFeatureComponent.builder()
                .authFeatureDependencies(authFeatureDependencies)
                .build()
        }
    }
}