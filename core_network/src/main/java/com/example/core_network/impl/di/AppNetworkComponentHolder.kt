package com.example.core_network.impl.di

import com.example.core_network.api.AppNetworkApi
import com.example.module_injector.ComponentHolder

object AppNetworkComponentHolder : ComponentHolder<AppNetworkApi, AppNetworkDependencies> {

    private var appNetworkComponent: AppNetworkComponent? = null
    override fun init(dependencies: AppNetworkDependencies) {
        if (appNetworkComponent == null) {
            synchronized(this) {
                if (appNetworkComponent == null) {
                    appNetworkComponent = AppNetworkComponent.get()
                }
            }
        }
    }

    override fun get(): AppNetworkApi = getComponent()

    internal fun getComponent(): AppNetworkComponent {
        checkNotNull(appNetworkComponent) { "AppNetworkComponent was not initialized!" }
        return appNetworkComponent!!
    }

    override fun reset() {
        appNetworkComponent = null
    }
}