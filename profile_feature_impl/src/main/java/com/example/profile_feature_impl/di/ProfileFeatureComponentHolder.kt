package com.example.profile_feature_impl.di

import com.example.module_injector.ComponentHolder
import com.example.profile_feature_api.ProfileFeatureApi

object ProfileFeatureComponentHolder : ComponentHolder<ProfileFeatureApi, ProfileFeatureDependencies> {
    private var profileFeatureComponent: ProfileFeatureComponent? = null
    override fun init(dependencies: ProfileFeatureDependencies) {
        if (profileFeatureComponent == null) {
            synchronized(this) {
                if (profileFeatureComponent == null) {
                    profileFeatureComponent = ProfileFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): ProfileFeatureApi = getComponent()

    internal fun getComponent(): ProfileFeatureComponent {
        checkNotNull(profileFeatureComponent) { "ProfileFeatureComponent was not initialized!" }
        return profileFeatureComponent!!
    }

    override fun reset() {
        profileFeatureComponent = null
    }
}