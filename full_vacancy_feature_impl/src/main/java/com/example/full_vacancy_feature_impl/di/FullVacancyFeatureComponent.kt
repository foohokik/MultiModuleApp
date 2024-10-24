package com.example.full_vacancy_feature_impl.di

import com.example.core_utils.di.Feature
import com.example.full_vacancy_feature_api.FullVacancyApi
import com.example.full_vacancy_feature_impl.presentation.FullVacancyFragment
import com.example.full_vacancy_feature_impl.presentation.FullVacancyViewModel
import dagger.Component

@Component(
    modules = [FullVacancyFeatureModule::class, DispatcherModule::class],
    dependencies = [FullVacancyFeatureDependencies::class]
)
@Feature
interface FullVacancyFeatureComponent : FullVacancyApi {

    fun inject(detailFragment: FullVacancyFragment)

    fun getDetailVacancyViewModelFactory(): FullVacancyViewModel.Factory

    companion object {
        fun initAndGet(fullVacancyFeatureDependencies: FullVacancyFeatureDependencies): FullVacancyFeatureComponent {
            return DaggerFullVacancyFeatureComponent.builder()
                .fullVacancyFeatureDependencies(fullVacancyFeatureDependencies)
                .build()
        }
    }
}