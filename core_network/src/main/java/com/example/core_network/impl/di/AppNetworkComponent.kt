package com.example.core_network.impl.di

import com.example.core_network.api.AppNetworkApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppNetworkComponent : AppNetworkApi {

    companion object {
        @Volatile
        private var appNetworkComponent: AppNetworkComponent? = null

        fun get(): AppNetworkComponent {
            if (appNetworkComponent == null) {
                synchronized(AppNetworkComponent::class.java) {
                    if (appNetworkComponent == null) {
                        appNetworkComponent = DaggerAppNetworkComponent.builder().build()
                    }
                }
            }
            return appNetworkComponent!!
        }
    }
}