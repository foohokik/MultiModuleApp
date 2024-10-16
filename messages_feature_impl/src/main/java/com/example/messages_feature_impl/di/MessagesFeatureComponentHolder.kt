package com.example.messages_feature_impl.di

import com.example.messages_feature_api.MessagesFeatureApi
import com.example.module_injector.ComponentHolder

object MessagesFeatureComponentHolder : ComponentHolder<MessagesFeatureApi, MessagesFeatureDependencies> {
    private var messagesFeatureComponent: MessagesFeatureComponent? = null
    override fun init(dependencies: MessagesFeatureDependencies) {
        if (messagesFeatureComponent == null) {
            synchronized(this) {
                if (messagesFeatureComponent == null) {
                    messagesFeatureComponent = MessagesFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): MessagesFeatureApi = getComponent()

    internal fun getComponent(): MessagesFeatureComponent {
        checkNotNull(messagesFeatureComponent) { "MessagesFeatureComponent was not initialized!" }
        return messagesFeatureComponent!!
    }

    override fun reset() {
        messagesFeatureComponent = null
    }
}