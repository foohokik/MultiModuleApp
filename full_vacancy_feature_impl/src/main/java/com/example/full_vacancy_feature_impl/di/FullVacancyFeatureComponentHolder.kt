package com.example.full_vacancy_feature_impl.di

import com.example.full_vacancy_feature_api.FullVacancyApi
import com.example.module_injector.ComponentHolder

object FullVacancyFeatureComponentHolder :
    ComponentHolder<FullVacancyApi, FullVacancyFeatureDependencies> {

    private var fullVacancyComponent: FullVacancyFeatureComponent? = null

    override fun init(dependencies: FullVacancyFeatureDependencies) {
        if (fullVacancyComponent == null) {
            synchronized(this) {
                if (fullVacancyComponent == null) {
                    fullVacancyComponent = FullVacancyFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): FullVacancyApi = getComponent()

    internal fun getComponent(): FullVacancyFeatureComponent {
        checkNotNull(fullVacancyComponent) { "FullVacancyFeatureComponent was not initialized!" }
        return fullVacancyComponent!!
    }

    override fun reset() {
        fullVacancyComponent = null
    }
}