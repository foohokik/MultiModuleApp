package com.example.favorite_feature_impl.presentation.adapter

import com.example.favorite_feature_impl.presentation.model.VacancyUI

interface VacancyItemListener {

    fun onVacancyClickListener (vacancy: VacancyUI)

    fun onFavoriteIconClick (vacancy: VacancyUI)

}


