package com.example.search_feature_impl.di

import com.example.core_utils.di.Feature
import com.example.search_feature_impl.presentation.ScreenSearchState
import com.example.search_feature_impl.presentation.SideEffects
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow

@Module

class FlowModule {

    @Feature
    @Provides
    fun provideMutableEffectChannel(): Channel<SideEffects> {
        return Channel()
    }

    @Feature
    @Provides
    fun provideMutableScreenStateFlow(): MutableStateFlow<ScreenSearchState> {
        return MutableStateFlow(ScreenSearchState())
    }

}