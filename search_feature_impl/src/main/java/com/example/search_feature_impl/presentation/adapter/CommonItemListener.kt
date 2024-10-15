package com.example.search_feature_impl.presentation.adapter

import com.example.search_feature_impl.presentation.model.OffersUI

interface CommonItemListener : VacancyItemListener, ButtonItemListener
interface VacancyItemListener {

    fun onVacancyClickListener (vacancy: OffersUI.VacancyUI)

    fun onFavoriteIconClick (vacancy: OffersUI.VacancyUI)

}

interface ButtonItemListener {
      fun onClickButton ()
}