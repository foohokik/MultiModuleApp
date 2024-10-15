package com.example.core_database.impl.di

import android.content.Context
import androidx.room.Room
import com.example.core_database.domain.VacancyDao
import com.example.core_database.impl.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database")
            .build()
    }

    @Provides
    fun provideNotesDao(appDatabase: AppDatabase): VacancyDao = appDatabase.vacancyDao
}