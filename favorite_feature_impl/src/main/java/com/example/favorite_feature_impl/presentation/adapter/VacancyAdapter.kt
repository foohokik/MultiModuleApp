package com.example.favorite_feature_impl.presentation.adapter

import com.example.favorite_feature_impl.presentation.model.VacancyUI
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class VacancyAdapter(listener:VacancyItemListener) :
    AsyncListDifferDelegationAdapter<VacancyUI>(
        VacancyItemDiffCallback(), vacancyDelegate(listener)
    )