package com.example.auth_feature_impl.di

import com.example.auth_feature_api.AuthFeatureApi
import com.example.module_injector.ComponentHolder

object AuthFeatureComponentHolder: ComponentHolder <AuthFeatureApi, AuthFeatureDependencies> {

    private var authFeatureComponent:AuthFeatureComponent?= null

    override fun init(dependencies: AuthFeatureDependencies) {
        if (authFeatureComponent == null) {
            synchronized(this) {
                if (authFeatureComponent == null) {
                    authFeatureComponent = AuthFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): AuthFeatureApi = getComponent()

    internal fun getComponent(): AuthFeatureComponent {
        checkNotNull(authFeatureComponent) { "AuthFeatureComponent was not initialized!" }
        return authFeatureComponent!!
    }

    override fun reset() {
        authFeatureComponent = null
    }
}