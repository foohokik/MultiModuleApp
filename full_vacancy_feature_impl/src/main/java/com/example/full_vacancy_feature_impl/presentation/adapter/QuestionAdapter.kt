package com.example.full_vacancy_feature_impl.presentation.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class QuestionAdapter(): ListDelegationAdapter<List<String>>(questionAdapterDelegate())