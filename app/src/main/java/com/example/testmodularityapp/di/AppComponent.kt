package com.example.testmodularityapp.di

import android.content.Context
import com.example.core_database.impl.di.AppDatabaseComponentHolder
import com.example.core_database.impl.di.AppDatabaseDependencies
import com.example.core_network.impl.di.AppNetworkComponentHolder
import com.example.core_network.impl.di.AppNetworkDependencies
import com.example.testmodularityapp.App
import com.example.testmodularityapp.MainActivity
import dagger.Component
import dagger.internal.Preconditions
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(app: App)
    fun inject(activity: MainActivity)


    companion object {
        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent {
            return Preconditions.checkNotNull(instance,
                "AppComponent is not initialized yet. Call init first.")!!
        }

        fun init(component: AppComponent, context: Context) {
            require(instance == null) { "AppComponent is already initialized." }
            instance = component
            AppDatabaseComponentHolder.init(object : AppDatabaseDependencies {
                override fun getContext(): Context {
                    return context
                }
            })
            AppNetworkComponentHolder.init(object : AppNetworkDependencies {
            })
        }
    }
}