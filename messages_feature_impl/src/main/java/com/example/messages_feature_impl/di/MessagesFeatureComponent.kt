package com.example.messages_feature_impl.di

import com.example.core_utils.di.Feature
import com.example.messages_feature_api.MessagesFeatureApi
import com.example.messages_feature_impl.presentation.MessageFragment
import dagger.Component

@Component(
    dependencies = [MessagesFeatureDependencies::class]
)
@Feature
interface MessagesFeatureComponent : MessagesFeatureApi {

    fun inject(messageFragment: MessageFragment)

    companion object {
        fun initAndGet(messagesFeatureDependencies: MessagesFeatureDependencies): MessagesFeatureComponent {
            return DaggerMessagesFeatureComponent.builder()
                .messagesFeatureDependencies(messagesFeatureDependencies)
                .build()
        }
    }
}