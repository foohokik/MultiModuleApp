package com.example.testmodularityapp.di

import android.content.Context
import com.example.auth_feature_api.AuthFeatureApi
import com.example.auth_feature_impl.di.AuthFeatureComponentHolder
import com.example.auth_feature_impl.di.AuthFeatureDependencies
import com.example.core_database.domain.VacancyDao
import com.example.core_database.impl.di.AppDatabaseComponentHolder
import com.example.core_database.impl.di.AppDatabaseDependencies
import com.example.core_network.impl.JobApi
import com.example.core_network.impl.di.AppNetworkComponentHolder
import com.example.core_network.impl.response.HttpResultToDataWrapperConverter
import com.example.favorite_feature_api.FavoriteApi
import com.example.favorite_feature_impl.di.FavoriteFeatureComponentHolder
import com.example.favorite_feature_impl.di.FavoriteFeatureDependencies
import com.example.full_vacancy_feature_api.FullVacancyApi
import com.example.full_vacancy_feature_impl.di.FullVacancyFeatureComponentHolder
import com.example.full_vacancy_feature_impl.di.FullVacancyFeatureDependencies
import com.example.messages_feature_api.MessagesFeatureApi
import com.example.messages_feature_impl.di.MessagesFeatureComponentHolder
import com.example.messages_feature_impl.di.MessagesFeatureDependencies
import com.example.profile_feature_api.ProfileFeatureApi
import com.example.profile_feature_impl.di.ProfileFeatureComponentHolder
import com.example.profile_feature_impl.di.ProfileFeatureDependencies
import com.example.responses_feature_api.ResponsesFeatureApi
import com.example.responses_feature_impl.di.ResponsesFeatureComponentHolder
import com.example.responses_feature_impl.di.ResponsesFeatureDependencies
import com.example.search_feature_api.SearchFeatureApi
import com.example.search_feature_impl.di.SearchFeatureComponentHolder
import com.example.search_feature_impl.di.SearchFeatureDependencies
import com.example.testmodularityapp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

	@Singleton
	@Provides
	fun provideContext(): Context {
		return App.appContext
	}

	@Singleton
	@Provides
	fun provideAppDatabaseDependencies(context: Context): AppDatabaseDependencies {
		return object : AppDatabaseDependencies {
			override fun getContext(): Context {
				return context
			}
		}
	}

	@Singleton
	@Provides
	fun provideFeatureSearchDependencies(): SearchFeatureDependencies {
		return object : SearchFeatureDependencies {
			override fun getVacanciesDao(): VacancyDao = AppDatabaseComponentHolder.get().getVacancyDao()
			override fun getJobApi(): JobApi = AppNetworkComponentHolder.get().getJobApi()
			override fun getConvertor(): HttpResultToDataWrapperConverter = AppNetworkComponentHolder.get().getConvertorForResponse()
		}
	}

	@Provides
	fun provideFeatureSearch(dependencies: SearchFeatureDependencies): SearchFeatureApi {
		SearchFeatureComponentHolder.init(dependencies)
		return SearchFeatureComponentHolder.get()
	}

	@Singleton
	@Provides
	fun provideFeatureFullVacancyDependencies() : FullVacancyFeatureDependencies{
		return object : FullVacancyFeatureDependencies {
			override fun getVacanciesDao(): VacancyDao = AppDatabaseComponentHolder.get().getVacancyDao()
		}
	}

	@Provides
	fun provideFeatureFullVacancy(dependencies: FullVacancyFeatureDependencies): FullVacancyApi {
		FullVacancyFeatureComponentHolder.init(dependencies)
		return FullVacancyFeatureComponentHolder.get()
	}

	@Singleton
	@Provides
	fun provideFeatureFavoriteDependencies() : FavoriteFeatureDependencies{
		return object : FavoriteFeatureDependencies {
			override fun getVacanciesDao(): VacancyDao = AppDatabaseComponentHolder.get().getVacancyDao()
		}
	}

	@Provides
	fun provideFeatureFavorite (dependencies: FavoriteFeatureDependencies): FavoriteApi {
		FavoriteFeatureComponentHolder.init(dependencies)
		return FavoriteFeatureComponentHolder.get()
	}

	@Singleton
	@Provides
	fun provideFeatureAuthDependencies() : AuthFeatureDependencies{
		return object : AuthFeatureDependencies {
		}
	}

	@Provides
	fun provideFeatureAuth (dependencies: AuthFeatureDependencies): AuthFeatureApi {
		AuthFeatureComponentHolder.init(dependencies)
		return AuthFeatureComponentHolder.get()
	}

	@Singleton
	@Provides
	fun provideFeatureProfileDependencies() : ProfileFeatureDependencies {
		return object : ProfileFeatureDependencies {
		}
	}

	@Provides
	fun provideFeatureProfile (dependencies: ProfileFeatureDependencies): ProfileFeatureApi {
		ProfileFeatureComponentHolder.init(dependencies)
		return ProfileFeatureComponentHolder.get()
	}

	@Singleton
	@Provides
	fun provideFeatureResponsesDependencies() : ResponsesFeatureDependencies {
		return object : ResponsesFeatureDependencies {
		}
	}

	@Provides
	fun provideFeatureResponses (dependencies: ResponsesFeatureDependencies): ResponsesFeatureApi {
		ResponsesFeatureComponentHolder.init(dependencies)
		return ResponsesFeatureComponentHolder.get()
	}

	@Singleton
	@Provides
	fun provideFeatureMessagesDependencies() : MessagesFeatureDependencies {
		return object : MessagesFeatureDependencies {
		}
	}

	@Provides
	fun provideFeatureMessages (dependencies: MessagesFeatureDependencies): MessagesFeatureApi {
		MessagesFeatureComponentHolder.init(dependencies)
		return MessagesFeatureComponentHolder.get()
	}

}