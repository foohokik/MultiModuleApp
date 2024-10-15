package com.example.search_feature_impl.presentation.adapter

import com.example.search_feature_impl.presentation.model.OffersUI
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class SearchAdapter (listener: CommonItemListener) :
    AsyncListDifferDelegationAdapter<OffersUI> (
        SearchAdapterDiffCallback(),
        offerRecycleDelegate(),
        vacancyDelegate(listener),
        headerDelegate(),
        buttonDelegate(listener)
    )
