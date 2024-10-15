package com.example.search_feature_impl.presentation.adapter

import com.example.search_feature_impl.presentation.model.OfferUI
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class OfferAdapter () :
    AsyncListDifferDelegationAdapter<OfferUI>(
        OfferItemDiffCallback(), offerDelegate()
    )