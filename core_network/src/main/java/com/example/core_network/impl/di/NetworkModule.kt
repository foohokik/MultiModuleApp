package com.example.core_network.impl.di

import com.example.core_network.impl.JobApi
import com.example.core_network.impl.response.HttpResultToDataWrapperConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {

        const val BASE_URL = "https://drive.usercontent.google.com"

        @Provides
        fun provideGson(): Gson {
            return GsonBuilder().create()
        }

        @Provides
        fun provideOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .followRedirects(true)
                .followSslRedirects(true)
                .build()
        }

        @Provides
        fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        @Provides
        @Singleton
        fun provideApiService(retrofit: Retrofit): JobApi =
            retrofit.create(JobApi::class.java)
    

    @Provides
    @Singleton
    fun provideConverter(): HttpResultToDataWrapperConverter {
        return HttpResultToDataWrapperConverter()
    }
}