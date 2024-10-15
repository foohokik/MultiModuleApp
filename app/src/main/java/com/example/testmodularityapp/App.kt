package com.example.testmodularityapp

import android.app.Application
import android.content.Context
import com.example.testmodularityapp.di.AppComponent
import com.example.testmodularityapp.di.DaggerAppComponent

class App: Application() {


    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        AppComponent.init(
            DaggerAppComponent.builder()
                .build(), appContext
        )

//        AppDatabaseComponentHolder.init(object : AppDatabaseDependencies {
//            override fun getContext(): Context {
//                return applicationContext
//            }
//        })

        AppComponent.get().inject(this)

    }

    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }
}