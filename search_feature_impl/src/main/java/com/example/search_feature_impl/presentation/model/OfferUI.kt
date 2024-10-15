package com.example.search_feature_impl.presentation.model

import androidx.annotation.DrawableRes

data class OfferUI(
    val button: String = "",
    val id: String,
    val link: String,
    val title: String,
    @DrawableRes val icon: Int
)