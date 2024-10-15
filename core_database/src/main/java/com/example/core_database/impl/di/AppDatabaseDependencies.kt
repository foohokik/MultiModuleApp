package com.example.core_database.impl.di

import android.content.Context
import com.example.module_injector.BaseDependencies

interface AppDatabaseDependencies: BaseDependencies {
	fun getContext(): Context
}