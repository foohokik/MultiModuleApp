package com.example.core_database.impl.di

import android.util.Log
import com.example.core_database.api.AppDatabaseApi
import com.example.module_injector.ComponentHolder


object AppDatabaseComponentHolder : ComponentHolder<AppDatabaseApi, AppDatabaseDependencies> {
    private var appDatabaseComponent: AppDatabaseComponent? = null
    override fun init(dependencies: AppDatabaseDependencies) {
        if (appDatabaseComponent == null) {
            synchronized(this) {
                if (appDatabaseComponent == null) {
                    appDatabaseComponent = AppDatabaseComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): AppDatabaseApi = getComponent()

    internal fun getComponent(): AppDatabaseComponent {
        Log.i("myTag", "getComponent Database " + appDatabaseComponent)
        checkNotNull(appDatabaseComponent) { "AppDatabaseComponent was not initialized!" }
        return appDatabaseComponent!!
    }

    override fun reset() {
        appDatabaseComponent = null
    }
}